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

    @NotEmpty
    private String passwd; // 可以使用驼峰命名，mybits会自动识别，但是保险起见还是使用原名

    private String tag;

    private String ranks;
    
    private String company;

    private int kills;

    private int attendance;

    private double balance;

    private String userpic;

    private LocalDateTime createtime;

    private LocalDateTime updatetime;

}
