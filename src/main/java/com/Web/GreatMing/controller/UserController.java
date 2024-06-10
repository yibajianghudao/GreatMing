package com.Web.GreatMing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.service.UserServiceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class UserController {

    @Autowired
    private UserServiceimpl userService;

    @PostMapping("/adduser")
    public Response<?> addNewUser(@RequestBody UserDTO userDTO) {
        User user = userService.findByName(userDTO.getName());
        if (user != null){
            return Response.newFail("This name is be used.");
        }else{
            userService.addNewUser(userDTO);
            User user2 = userService.findByName(userDTO.getName());
            if (user2.getId() >= -1) {
                return Response.newSuccess(user2.getId(), "Add user success!");
            }else{
                return Response.newFail("Add User Failed.");
            }
            
        }
    }
    

    @GetMapping("/user/{id}")
    public Response<UserDTO> getStudentById(@PathVariable long id){
            return Response.newSuccess(userService.getUserById(id), "成功返回用户信息");
    }
    // @PostMapping("/adduser")
    // public Response<Long> addNewUser(@RequestBody UserDTO userDTO) {
    //     return Response.newSuccess(userService.addNewUser(userDTO), "成功添加用户");
    // }
    @DeleteMapping("/deluser/{id}")
    public Response<Void> delUserById(@PathVariable long id) {
        userService.deleteUserById(id);
        return Response.newSuccess(null);
    }
    @PutMapping("updateuser/{id}")
    public Response<UserDTO> updateUserById(@PathVariable long id, @RequestBody UserDTO userDTO) {
        // 此API不应传输passwd参数
        UserDTO userUpdateDTO = userService.updateUserById(id, userDTO);
        return Response.newSuccess(userUpdateDTO, "成功更新数据");
    }
    
    

}
