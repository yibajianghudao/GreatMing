package com.Web.GreatMing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.service.UserService;

@RestController
public class LoginController {
    
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Response<?> login(@RequestParam(name = "name") String name, @RequestParam(name = "passwd") String passwd) {
        return Response.newSuccess(userService.login(name, passwd), "登录成功！");
    }

}
