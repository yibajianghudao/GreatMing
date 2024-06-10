package com.Web.GreatMing.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.Web.GreatMing.converter.UserConverter;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dao.UsersMapper;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.utils.Md5Util;

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
    }
    @Override
    public UserDTO getUserById(long id) {
        User user = userMapper.findById(id);
        return UserConverter.converterUser(user);
    }
    
    @Override
    public void deleteUserById(long id) {
        userMapper.findById(id);
        // userMapper.deleteById(id);
    }

    @Override
    @Transactional //操作失败后回滚
    public UserDTO updateUserById(long id, UserDTO userDTO) {
        userMapper.findById(id);
        User user = userMapper.findById(id);
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
        // User addUser = userMapper.save(user);
        User addUser = new User();
        return UserConverter.converterUser(addUser);
    }

}
