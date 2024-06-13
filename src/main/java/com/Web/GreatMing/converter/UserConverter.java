package com.Web.GreatMing.converter;

import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dto.UserDTO;

public class UserConverter {
    // 将后端的User类转换为发送给前端的UserDTO类    
    public static UserDTO converterUser(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        // userDTO.setPasswd(user.getPasswd()); // 后端并不将passwd传给前端，登陆需要走另外的API
        userDTO.setTag(user.getTag());
        userDTO.setRanks(user.getRanks());
        userDTO.setCompany(user.getCompany());
        userDTO.setKills(user.getKills());
        userDTO.setAttendance(user.getAttendance());
        userDTO.setBalance(user.getBalance());
        userDTO.setUserpic(user.getUserpic());
        userDTO.setCreatetime(user.getCreatetime());
        userDTO.setUpdatetime(user.getUpdatetime());
        return userDTO;
    }
    // 将接收到的前端的UserDTO类转换成User   
    // 此处并未转换DTO到User的创建时间和更新时间
    public static User converterUserDTO(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPasswd(userDTO.getPasswd());
        user.setTag(userDTO.getTag());
        user.setRanks(userDTO.getRanks());
        user.setCompany(userDTO.getCompany());
        user.setKills(userDTO.getKills());
        user.setAttendance(userDTO.getAttendance());
        user.setBalance(userDTO.getBalance());
        user.setUserpic(userDTO.getUserpic());
        return user;
    }
}
