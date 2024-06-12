package com.Web.GreatMing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.service.UserService;

@RestController
public class LoginController {
    
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Response<?> login(@RequestBody UserDTO userLoginDTO) {
        return Response.newSuccess(userService.login(userLoginDTO), "登录成功！");
    }

}
