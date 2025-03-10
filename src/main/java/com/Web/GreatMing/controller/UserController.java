package com.Web.GreatMing.controller;

import org.springframework.web.bind.annotation.*;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.converter.UserConverter;
import com.Web.GreatMing.dao.BalanceUpdate;
import com.Web.GreatMing.dao.PageBean;
import com.Web.GreatMing.dao.User;
import com.Web.GreatMing.dto.UserDTO;
import com.Web.GreatMing.service.BalanceUpdateService;
import com.Web.GreatMing.service.UserService;
import com.Web.GreatMing.utils.JwtUtil;
import com.Web.GreatMing.utils.Md5Util;
import com.Web.GreatMing.utils.ThreadLocalUtil;


import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@CrossOrigin(maxAge = 3600, methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.OPTIONS })
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private BalanceUpdateService balanceUpdateService;

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
    

    @GetMapping("/userInfo")
    public Response<?> userInfo(/* @RequestHeader(name = "Authorization") String token */) {
        
        // Map<String, Object> map = JwtUtil.parseToken(token);
        
        Map<String, Object> map = ThreadLocalUtil.get();
        String name = (String) map.get("name");
        User infoUser = userService.findByName(name);
        UserDTO infoUserDTO = UserConverter.converterUser(infoUser);

        return Response.newSuccess(infoUserDTO, "查询用户信息成功.");
    }

    @GetMapping("/userblanceupdatelog")
    public Response<?> getuserbalnceupdatelog() {
        Map<String, Object> map = ThreadLocalUtil.get();
        String name = (String) map.get("name");
        List<BalanceUpdate> balanceUpdates = balanceUpdateService.getListBalanceUpdatesByName(name);
        if (balanceUpdates.size() != 0) {
            return Response.newSuccess(balanceUpdates, "get balanceupdatelog success.");
        }else{
            return Response.newFail("get balanceupdatelog failed.");
        }
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
        // 此API不应传输passwd,userpic参数
        UserDTO newUserDTO = userService.updateUser(userDTO);
        return Response.newSuccess(newUserDTO, "用户信息更新成功！");
    }

    @PatchMapping("/updateAvatar")
    public Response<?> updateAvatar(@RequestParam @URL String avatatUrl){
        userService.updateAvatar(avatatUrl);

        return Response.newSuccess("成功更新用户头像.");

    }

    // 获取token的入参似乎可以删除了
//    @CrossOrigin
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
    public Response<PageBean<UserDTO>> userPageList(
        @RequestParam Integer pageNum,
        @RequestParam Integer pageSize,
        @RequestParam(required = false) String company
    ){
        PageBean<UserDTO> pb = userService.userPageList(pageNum, pageSize, company);
        return Response.newSuccess(pb, "返回数据列表成功.");
    }
    
    
    
    
    

}
