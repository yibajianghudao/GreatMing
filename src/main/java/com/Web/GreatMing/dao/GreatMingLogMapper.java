package com.Web.GreatMing.dao;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT * FROM greatminglogs WHERE date >= #{startDate} AND date < #{endDate}")
    List<GreatMingLog> findGreatMingLogsByDateRange(LocalDate startDate, LocalDate endDate);

    @Delete("delete from greatminglogs where id=#{id}")
    void deleteGreatMingLogsById(long id);

    @Insert("insert into greatminglogs(date, name, kills) values(#{date},#{name},#{kills})")
    void addGreatMingLog(GreatMingLog greatMingLog);




}
