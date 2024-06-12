package com.Web.GreatMing.service;

import java.lang.NullPointerException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.Web.GreatMing.converter.UserConverter;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dao.UsersMapper;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.exception.PasswordWrongException;
import com.Web.GreatMing.utils.JwtUtil;
import com.Web.GreatMing.utils.Md5Util;

import jakarta.validation.ConstraintViolationException;

@Service
public class UserServiceimpl implements UserService {
    
    @Autowired
    private UsersMapper userMapper;
    
    @Override
    public User findByName(String username){
        User user = userMapper.findByName(username);
        return user;
    }
    @Override
    public void addNewUser(UserDTO userDTO) {
        if(userDTO.getName().length() >= 1 &&userDTO.getName().length() <= 16 && userDTO.getPasswd().length() >= 6 && userDTO.getPasswd().length() <= 16){
            String name = userDTO.getName();
            String Md5String = Md5Util.getMD5String(userDTO.getPasswd());
            String tag = userDTO.getTag();
            String ranks = userDTO.getRanks();
            String company = userDTO.getCompany();
            int kills = userDTO.getKills();
            int attendance = userDTO.getAttendance();
            int balance = userDTO.getBalance();
            String enrollmentTime = userDTO.getEnrollmentTime();
            userMapper.addNewUser(name, Md5String, tag, ranks, company, kills, attendance, balance, enrollmentTime);
            return;
        }else {
            throw new ConstraintViolationException("用户名需要在1-16位之间,密码需要在6-16位之间", null);
        }
        
    }
    @Override
    public UserDTO getUserById(long id) {
        User user = userMapper.findById(id);
        return UserConverter.converterUser(user);
    }
    
    @Override
    public void deleteUserById(long id) {
        User user = userMapper.findById(id);
        if(user == null) throw new NullPointerException();
        userMapper.deleteById(id);
        System.out.println("delete is be used.");
    }

    @Override
    @Transactional //操作失败后回滚
    public UserDTO updateUserById(long id, UserDTO userDTO) {
        User user = userMapper.findById(id);
        if(user == null) throw new NullPointerException();
        if (StringUtils.hasLength(userDTO.getName()) && !userDTO.getName().equals(user.getName())) {
            user.setName(userDTO.getName());
        }
        // if (StringUtils.hasLength(userDTO.getPasswd()) && !userDTO.getPasswd().equals(user.getPasswd())) {
        //     user.setPasswd(userDTO.getPasswd());
        // }
        if (StringUtils.hasLength(userDTO.getTag()) && !userDTO.getTag().equals(user.getTag())) {
            user.setTag(userDTO.getTag());
        }
        if (StringUtils.hasLength(userDTO.getRanks()) && !userDTO.getRanks().equals(user.getRanks())) {
            user.setRanks(userDTO.getRanks());
        }
        if (StringUtils.hasLength(userDTO.getCompany()) && !userDTO.getCompany().equals(user.getCompany())) {
            user.setCompany(userDTO.getCompany());
        }
        if (userDTO.getKills() != 0 && (userDTO.getKills() != user.getKills())) {
            user.setKills(userDTO.getKills());
        }
        if (userDTO.getAttendance() != 0 && (userDTO.getAttendance() != user.getAttendance())) {
            user.setAttendance(userDTO.getAttendance());
        }
        if (userDTO.getBalance() != 0 && (userDTO.getBalance() != user.getBalance())) {
            user.setBalance(userDTO.getBalance());
        }
        if (StringUtils.hasLength(userDTO.getEnrollmentTime()) && !userDTO.getEnrollmentTime().equals(user.getEnrollmentTime())) {
            user.setEnrollmentTime(userDTO.getEnrollmentTime());
        }
        // 更新后的UserDTO
        userMapper.updateUser(user.getName(), user.getId());
        return UserConverter.converterUser(userMapper.findById(id));
    }
    public String login(String name, String passwd) {
        if(name.length() >= 1 &&name.length() <= 16 && passwd.length() >= 6 && passwd.length() <= 16){
            User loginuser = userMapper.findByName(name);
            try {
                if (loginuser.getPasswd().equals(Md5Util.getMD5String(passwd))){
                    // 登录成功
                    Map<String, Object> claims = new HashMap<>();
                    claims.put("id", loginuser.getId());
                    claims.put("name", loginuser.getName());
                    String token = JwtUtil.genToken(claims);
    
                    return token;
                }else{
                    throw new PasswordWrongException("密码错误！");
                }
            } catch (NullPointerException e) {
                throw new PasswordWrongException("用户名不存在");
            }
            
        }else {
            throw new PasswordWrongException("用户名需要在1-16位之间,密码需要在6-16位之间");
        }
        

    }

}
