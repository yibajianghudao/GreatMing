package com.Web.GreatMing.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    // 此处为了新建用户时设置密码，似乎也要在这里添加一个password属性。
    private long id;

    private String name;

    private String passwd;

    private String tag;

    private String ranks;
    
    private String company;

    private int kills;

    private int attendance;

    private int balance;

    private String enrollmentTime;

}
