package com.Web.GreatMing.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.Web.GreatMing.converter.UserConverter;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dao.UserRepository;
import com.Web.GreatMing.dto.UserDTO;

@Service
public class UserService implements UserServiceimpl {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        return UserConverter.converterUser(user);
    }
    @Override
    public Long addNewUser(UserDTO userDTO) {
        List<User> userList  = userRepository.findByName(userDTO.getName());
        if (!org.springframework.util.CollectionUtils.isEmpty(userList)){
            throw new IllegalStateException("name:" + userDTO.getName() + " is bew used.");
        }
        User user = UserConverter.converterUserDTO(userDTO);
        LocalDateTime now = LocalDateTime.now();
        user.setCreatetime(Timestamp.valueOf(now));
        // 无法在此处添加Updatetime，数据库会在更新的时候自动添加（调用API没有尝试过）
        User addUser = userRepository.save(user);
        return addUser.getId();
    }
    @Override
    public void deleteUserById(long id) {
        userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id" + id + "doesn't exist."));
        userRepository.deleteById(id);
    }

    @Override
    @Transactional //操作失败后回滚
    public UserDTO updateUserById(long id, UserDTO userDTO) {
        userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id" + id + "doesn't exist."));
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
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
        User addUser = userRepository.save(user);
        return UserConverter.converterUser(addUser);
    }

}
