package com.Web.GreatMing.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.Web.GreatMing.dto.UserDTO;


@Mapper()
public interface UsersMapper{
    
    @Select("select * from Users where name=#{name}")
    User findByName(String name);

    @Select("select * from Users where id=#{id}")
    User findById(long id);

    @Insert("insert into Users(name, passwd, tag, ranks, company, kills, attendance, balance, enrollmentTime, createtime, updatetime)" + 
    " values(#{name}, #{passwd}, #{tag}, #{ranks}, #{company}, #{kills}, #{attendance}, #{balance}, #{enrollmentTime}, now(), now())")
    void addNewUser(String name, String passwd, String tag, String ranks, String company, int kills, int attendance,
            int balance, String enrollmentTime);

    @Delete("delete from Users where id=#{id}")
    void deleteById(long id);

    @Update("update Users set name=#{name},passwd=#{passwd},tag=#{tag},ranks=#{ranks},company=#{company},kills=#{kills},attendance=#{attendance},balance=#{balance},enrollmentTime=#{enrollmentTime},updatetime=NOW() where id=#{id}")
    void updateUser(UserDTO userDTO);



}
