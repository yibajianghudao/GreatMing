package com.Web.GreatMing.dao;

import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper()
public interface GreatMingLogMapper {

    @Select("select * from greatminglogs")
    List<GreatMingLog> selectAllGreatMingLogs();

    @Select("select * from greatminglogs where id=#{id}")
    GreatMingLog findGreatMingLogsById(long id);

    @Select("select * from greatminglogs where name=#{name}")
    List<GreatMingLog> findGreatMingLogsByName(String name);


    @Select("select * from greatminglogs where date=#{date}")
    List<GreatMingLog> findGreatMingLogsByDate(LocalDate date);

    @Select("select * from greatminglogs where date=#{date} and name=#{name}")
    List<GreatMingLog> findGreatMingLogsByDateName(LocalDate date, String name);



    @Delete("delete from greatminglogs where id=#{id}")
    void deleteGreatMingLogsById(long id);

    @Insert("insert into greatminglogs(date, name, kills) values(#{date},#{name},#{kills})")
    void addGreatMingLog(GreatMingLog greatMingLog);




}
