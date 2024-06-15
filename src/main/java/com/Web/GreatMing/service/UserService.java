package com.Web.GreatMing.service;


import java.util.List;

import com.Web.GreatMing.dao.PageBean;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dto.UserDTO;

public interface UserService {
    public User findByName(String username);
    public UserDTO getUserById(long id);
    public void addNewUser(UserDTO userDTO);
    public void deleteUserById(long id);
    public UserDTO updateUser(Long id, UserDTO userDTO);
    public String login(String name, String passwd);
    public void updateAvatar(String avatatUrl);
    public void updatePasswd(String newPasswd);
    public List<User> getUserList();
    PageBean<User> userPageList(Integer pageNum, Integer pageSize, String company);
}
