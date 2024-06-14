package com.Web.GreatMing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



@Mapper()
public interface UsersMapper{
    
    @Select("select * from Users where name=#{name}")
    User findByName(String name);

    @Select("select * from Users where id=#{id}")
    User findById(long id);

    @Insert("insert into Users(name, passwd, tag, ranks, company, kills, attendance, balance, userpic, createtime, updatetime)" + 
    " values(#{name}, #{passwd}, #{tag}, #{ranks}, #{company}, #{kills}, #{attendance}, #{balance}, #{userpic}, now(), now())")
    void addNewUser(User user);

    @Delete("delete from Users where id=#{id}")
    void deleteById(long id);

    @Update("update Users set name=#{name},passwd=#{passwd},tag=#{tag},ranks=#{ranks},company=#{company},kills=#{kills},attendance=#{attendance},balance=#{balance},userpic=#{userpic},updatetime=NOW() where id=#{id}")
    void updateUser(User userDTO);

    @Update("update Users set userpic=#{avatatUrl},updatetime=NOW() where id=#{id}")
    void updateAvatar(long id, String avatatUrl);

    @Update("update Users set passwd=#{passwd},updatetime=NOW() where id=#{id}")
    void updatePasswd(Long id, String passwd);

    @Select("select * from Users")
    List<User> getUserList();



}
