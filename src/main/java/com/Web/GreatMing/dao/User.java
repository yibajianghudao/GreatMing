package com.Web.GreatMing.dao;


import lombok.Data;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


// 数据库表映射类
@Data
public class User {
    @NotNull
    private long id;
    @NotEmpty
    private String name;
    @JsonIgnore
    private String passwd;

    private String tag;

    private String ranks;
    
    private String company;

    private int kills;

    private int attendance;

    private int balance;

    private String enrollmentTime;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;

}
