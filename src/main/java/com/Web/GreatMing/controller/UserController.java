package com.Web.GreatMing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.converter.UserConverter;
import com.Web.GreatMing.dao.PageBean;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.service.UserServiceimpl;
import com.Web.GreatMing.utils.JwtUtil;
import com.Web.GreatMing.utils.Md5Util;
import com.Web.GreatMing.utils.ThreadLocalUtil;


import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceimpl userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/adduser")
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
    
    @GetMapping("/{id}")
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

    @GetMapping("/userInfo")
    public Response<?> userInfo(/* @RequestHeader(name = "Authorization") String token */) {
        
        // Map<String, Object> map = JwtUtil.parseToken(token);
        
        Map<String, Object> map = ThreadLocalUtil.get();
        String name = (String) map.get("name");
        User infoUser = userService.findByName(name);
        UserDTO infoUserDTO = UserConverter.converterUser(infoUser);

        return Response.newSuccess(infoUserDTO, "查询用户信息成功.");
    }
    

    
    @DeleteMapping("/deluser/{id}")
    public Response<?> delUserById(@PathVariable long id) {
        try {
            userService.deleteUserById(id);
            return Response.newSuccess(null);
        } catch (NullPointerException e) {
            return Response.newFail("该id用户不存在", e.toString());
        }
        
    }
    @PutMapping("/update")
    public Response<?> updateUser(@RequestBody @Validated UserDTO userDTO) {
        // 前端需要传递显示全部的属性，未更新也要传递
        // 密码,头像等需要走单独的接口进行修改
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer idiInteger =  (Integer) map.get("id");
        Long id = idiInteger.longValue();
        // 此API不应传输passwd参数
        UserDTO newUserDTO = userService.updateUser(id, userDTO);
        return Response.newSuccess(newUserDTO, "用户信息更新成功！");
    }

    @PatchMapping("/updateAvatar")
    public Response<?> updateAvatar(@RequestParam @URL String avatatUrl){
        userService.updateAvatar(avatatUrl);

        return Response.newSuccess("成功更新用户头像.");

    }

    @PatchMapping("/updatepasswd")
    public Response<?> updatePasswd(@RequestBody Map<String, String> params, @RequestHeader("Authorization") String token){
        // 校验参数
        String oldPasswd = params.get("old_passwd");
        String newPasswd = params.get("new_passwd");
        String rePasswd = params.get("re_passwd");

        if(!StringUtils.hasLength(oldPasswd) || !StringUtils.hasLength(newPasswd) || !StringUtils.hasLength(rePasswd)){
            return Response.newFail("缺少必要的参数");
        }

        // 原密码是否正确
        Map<String, Object> map = ThreadLocalUtil.get();
        String name = (String) map.get("name");
        Integer idiInteger =  (Integer) map.get("id");
        Long id = idiInteger.longValue();
        User loginUser = userService.findByName(name);
        if (!loginUser.getPasswd().equals(Md5Util.getMD5String(oldPasswd))){
            return Response.newFail("原密码填写不正确");
        }

        if (!rePasswd.equals(newPasswd)){
            return Response.newFail("两次填写的新密码不同");
        }

        if (!(newPasswd.length() >= 6 && newPasswd.length() <= 16) ) {
            return Response.newFail("密码需要在6-16位之间");
        }
        if (oldPasswd.equals(newPasswd)) {
            return Response.newFail("新密码不能与旧密码相同");
        }

        userService.updatePasswd(newPasswd);

        String keyString = id.toString();
        // ValueOperations operations = stringRedisTemplate.opsForValue();
        stringRedisTemplate.delete(keyString);
        return Response.newSuccess("密码更新成功");


    }


    @GetMapping("/userlist")
    public Response<List<User>> getUserList() {
        List<User> list = userService.getUserList();
        return Response.newSuccess(list, "成功返回用户列表");
    }

    @GetMapping("/userpagelist")
    public Response<PageBean<User>> userPageList(
        Integer pageNum,
        Integer pageSize,
        @RequestParam(required = false) String company
    ){
        PageBean<User> pb = userService.userPageList(pageNum, pageSize, company);
        return Response.newSuccess(pb, "返回数据列表成功.");
    }
    
    
    
    
    

}
