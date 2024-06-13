package com.Web.GreatMing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.converter.UserConverter;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.service.UserServiceimpl;
import com.Web.GreatMing.utils.JwtUtil;
import com.Web.GreatMing.utils.ThreadLocalUtil;

import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
public class UserController {

    @Autowired
    private UserServiceimpl userService;

    @PostMapping("/user/adduser")
    public Response<?> addNewUser(@RequestBody UserDTO userDTO) {
        User user = userService.findByName(userDTO.getName());
        if (user != null){
            return Response.newFail("This name is be used.");
        }else{
                userService.addNewUser(userDTO);
                User user2 = userService.findByName(userDTO.getName());
                if (user2 != null){
                    return Response.newSuccess(user2.getId(), "Add user success!");
                } else return Response.newFail("AddUser is Failed.");
        }
    }
    
    @GetMapping("/user/{id}")
    public Response<?> getStudentById(@PathVariable long id, @RequestHeader(name = "Authorization") String token, HttpServletResponse response){
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            
        }catch (Exception e){
            // 设置状态码response为401
            response.setStatus(401);
            return Response.newFail("令牌不合法，未登录。");
        }
        try {
            return Response.newSuccess(userService.getUserById(id), "成功返回用户信息");
        } catch (NullPointerException e) {
            return Response.newFail("该Id用户不存在", e.toString());
        }
        
    }

    @GetMapping("/user/userInfo")
    public Response<?> userInfo(/* @RequestHeader(name = "Authorization") String token */) {
        
        // Map<String, Object> map = JwtUtil.parseToken(token);
        
        Map<String, Object> map = ThreadLocalUtil.get();
        String name = (String) map.get("name");
        User infoUser = userService.findByName(name);
        UserDTO infoUserDTO = UserConverter.converterUser(infoUser);

        return Response.newSuccess(infoUserDTO, "查询用户信息成功.");
    }
    

    
    @DeleteMapping("/user/deluser/{id}")
    public Response<?> delUserById(@PathVariable long id) {
        try {
            userService.deleteUserById(id);
            return Response.newSuccess(null);
        } catch (NullPointerException e) {
            return Response.newFail("该id用户不存在", e.toString());
        }
        
    }
    @PutMapping("/user/update")
    public Response<?> updateUser(@RequestBody @Validated UserDTO userDTO) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer idiInteger =  (Integer) map.get("id");
        Long id = idiInteger.longValue();
        // 此API不应传输passwd参数
        UserDTO newUserDTO = userService.updateUser(id, userDTO);
        return Response.newSuccess(newUserDTO, "用户信息更新成功！");
    }
    
    
    
    

}
