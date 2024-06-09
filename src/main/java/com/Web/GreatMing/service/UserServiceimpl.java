package com.Web.GreatMing.service;


import com.Web.GreatMing.dto.UserDTO;

public interface UserServiceimpl {
    
    public UserDTO getUserById(long id);
    public Long addNewUser(UserDTO userDTO);
    public void deleteUserById(long id);
    public UserDTO updateUserById(long id, UserDTO userDTO);
}
