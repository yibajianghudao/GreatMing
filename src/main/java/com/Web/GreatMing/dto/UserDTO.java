package com.Web.GreatMing.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    // 此处为了新建用户时设置密码，似乎也要在这里添加一个password属性。
    private long id;

    @NotEmpty
    private String name;

    //转换为Json的时候忽略此属性，仅仅使用userDTO的话，返回的json依旧存在此属性，但是值为null
    // @JsonIgnore 
    private String passwd;

    private String tag;

    private String ranks;
    
    private String company;

    private int kills;

    private int attendance;

    private double balance;

    private String userpic;

    //设置转换为json时的日期格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatetime;

}
