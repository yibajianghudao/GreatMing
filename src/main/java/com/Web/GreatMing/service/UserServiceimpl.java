package com.Web.GreatMing.service;

import java.lang.NullPointerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Web.GreatMing.converter.UserConverter;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dao.UsersMapper;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.exception.PasswordWrongException;
import com.Web.GreatMing.utils.JwtUtil;
import com.Web.GreatMing.utils.Md5Util;
import com.Web.GreatMing.utils.ThreadLocalUtil;

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
            User user = UserConverter.converterUserDTO(userDTO);
            user.setPasswd(Md5Util.getMD5String(userDTO.getPasswd()));
            userMapper.addNewUser(user);
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
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userMapper.findById(id);
        // 将前端未传入的参数从user中取出并设置
        userDTO.setId(user.getId());
        userDTO.setPasswd(user.getPasswd());
        userDTO.setUserpic(user.getUserpic());
        User updatedUser = UserConverter.converterUserDTO(userDTO);
        userMapper.updateUser(updatedUser);
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
    public void updateAvatar(String avatatUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer idiInteger =  (Integer) map.get("id");
        Long id = idiInteger.longValue();
        userMapper.updateAvatar(id, avatatUrl);
    }
    public void updatePasswd(String newPasswd) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer idiInteger =  (Integer) map.get("id");
        Long id = idiInteger.longValue();
        userMapper.updatePasswd(id, Md5Util.getMD5String(newPasswd));
    }
    public List<User> getUserList() {
        List<User> list =  userMapper.getUserList();
        return list;
    }

}
