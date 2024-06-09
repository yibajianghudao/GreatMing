package com.Web.GreatMing.dao;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;


// 数据库表映射类
@Entity
@Table(name="Users")
@Getter 
@Setter
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = IDENTITY)    // 自增的ID
    private long id;

    @Column(name="name")    // 如果变量名字和数据库字段名字相同则不用写此注解
    private String name;

    @Column(name="passwd")
    private String passwd;

    @Column(name="tag")
    private String tag;

    @Column(name="ranks")
    private String ranks;
    
    @Column(name="company")
    private String company;

    @Column(name="kills")
    private int kills;

    @Column(name="attendance")
    private int attendance;

    @Column(name="balance")
    private int balance;

    @Column(name="enrollmentTime")
    private String enrollmentTime;

    @Column(name="createtime")
    private Timestamp createtime;

    @Column(name="updatetime")
    private Timestamp updatetime;

}
