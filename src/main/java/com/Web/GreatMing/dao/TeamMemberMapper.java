package com.Web.GreatMing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper()
public interface TeamMemberMapper {
    
    @Select("select * from TeamMembers")
    List<TeamMember> findAllTeamMember();

    @Select("select * from TeamMembers where id=#{id}")
    TeamMember findTeamMemberById(long id);

    @Select("select * from TeamMembers where name=#{name}")
    TeamMember findTeamMemberByName(String name);

    @Insert("insert into TeamMembers(name, qq, gender, age, microphone, company, know, timelength, disposition, timeonline, favoritegames, pastteams, position, behavior, createtime)" + 
    " values(#{name}, #{qq}, #{gender}, #{age}, #{microphone}, #{company}, #{know}, #{timelength}, #{disposition}, #{timeonline}, #{favoritegames}, #{pastteams}, #{position}, #{behavior}, now())")
    void addNewTeamMember(TeamMember teamMember);

    @Delete("delete from TeamMembers where id=#{id}")
    void deleteTeamMemberById(long id);
}
