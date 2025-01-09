package com.Web.GreatMing.service;

import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Web.GreatMing.converter.UserConverter;
import com.Web.GreatMing.dao.PageBean;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dao.UsersMapper;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.exception.PasswordWrongException;
import com.Web.GreatMing.utils.JwtUtil;
import com.Web.GreatMing.utils.Md5Util;
import com.Web.GreatMing.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import jakarta.validation.ConstraintViolationException;

@Service
public class UserService {
    
    @Autowired
    private UsersMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    public User findByName(String username){
        User user = userMapper.findByName(username);
        return user;
    }
    public void addNewUser(UserDTO userDTO) {
        // && userDTO.getPasswd().length() >= 6 && userDTO.getPasswd().length() <= 16
        if(userDTO.getName().length() >= 1 &&userDTO.getName().length() <= 16){
            userDTO.setTag("NewPlayer");
            User user = UserConverter.converterUserDTO(userDTO);
            user.setPasswd(Md5Util.getMD5String("123456"));
            userMapper.addNewUser(user);
            return;
        }else {
            throw new ConstraintViolationException("用户名需要在1-16位之间", null);
        }
        
    }
    public UserDTO getUserById(long id) {
        User user = userMapper.findUserById(id);
        return UserConverter.converterUser(user);
    }
    
    
    public void deleteUserById(long id) {
        User user = userMapper.findUserById(id);
        if(user == null) throw new NullPointerException();
        userMapper.deleteUserById(id);
//        System.out.println("delete is be used.");
    }

    
    @Transactional //操作失败后回滚
    public UserDTO updateUser(UserDTO userDTO) {
        long id = userDTO.getId();
        User user = userMapper.findUserById(id);
        // 将前端未传入的参数从user中取出并设置
        userDTO.setPasswd(user.getPasswd());
        userDTO.setUserpic(user.getUserpic());
        User updatedUser = UserConverter.converterUserDTO(userDTO);
        userMapper.updateUser(updatedUser);
        return UserConverter.converterUser(userMapper.findUserById(id));
    }
    
    public String login(String name, String passwd) {
        if(name.length() >= 1 &&name.length() <= 16 && passwd.length() >= 6 && passwd.length() <= 16){
            User loginuser = userMapper.findByName(name);
            try {
                if (loginuser.getPasswd().equals(Md5Util.getMD5String(passwd))){
                    // 登录成功
                    Long id = loginuser.getId();
                    Map<String, Object> claims = new HashMap<>();
                    claims.put("id", id);
                    claims.put("name", loginuser.getName());
                    String token = JwtUtil.genToken(claims);

                    // 把token存储到redis中(id:token)
                    String keyString = id.toString();
                    ValueOperations operations = stringRedisTemplate.opsForValue();
                    operations.set(keyString, token, 1, TimeUnit.HOURS);
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
    public PageBean<UserDTO> userPageList(Integer pageNum, Integer pageSize, String company) {
        // 创建PageBean对象
        PageBean<UserDTO> pb = new PageBean<>();

        // 开启分页查询(mybits插件)
        // 此处应该传回究竟可以分多少页
        PageHelper.startPage(pageNum, pageSize);

        // 调用Mapper执行sql
        List<User> as= userMapper.userPageList(company);

        List<UserDTO> asDTO = new LinkedList<>();
        for (User user : as) {
            asDTO.add(UserConverter.converterUser(user));
        }
        
        // 强制转换类型，因为Page中提供了方法获取PageHelper分页查询后得到的消息记录条数和当前页数据
        // 因为多态不允许父类(List<user>)调用子类Page<User>中特有的方法
        // Page<UserDTO> p = (Page<UserDTO>) asDTO;

        // 数据填充到PageBean对象中
        pb.setTotal((long) asDTO.size());
        pb.setItems(asDTO);
        
        // p.close();
        return pb;
    }

    public boolean reduceBalance(long id, double num){
        double balance = userMapper.findUserById(id).getBalance();
        if(balance < num){
            return false;
        }else {
            double newBalance = balance - num;
            userMapper.updateBalance(id, newBalance);
            return true;
        }
    }

    public boolean addBalance(long id, double num){
        double balance = userMapper.findUserById(id).getBalance();
        double newBalance = balance + num;
        userMapper.updateBalance(id, newBalance);
        double findBalance = userMapper.findUserById(id).getBalance();
        return findBalance == newBalance;
    }

}
