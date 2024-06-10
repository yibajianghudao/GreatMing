package com.Web.GreatMing.service;


import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dto.UserDTO;

public interface UserService {
    public User findByName(String username);
    public UserDTO getUserById(long id);
    public void addNewUser(UserDTO userDTO);
    public void deleteUserById(long id);
    public UserDTO updateUserById(long id, UserDTO userDTO);
}
