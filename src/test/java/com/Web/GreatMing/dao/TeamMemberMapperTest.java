package com.Web.GreatMing.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TeamMemberMapperTest {

    @Autowired
    private TeamMemberMapper teamMemberMapper;

    @Test
    @Order(1)
    void testAddTeamMember() {
        TeamMember teamMember = new TeamMember();
        teamMember.setName("jhddd");
        teamMember.setQq("132131123");
        teamMember.setPosition("无");
        teamMember.setCreatetime(LocalDateTime.now());
        teamMemberMapper.insert(teamMember);

    }


    @Test
    @Order(2)
    void testFindByTeamId()  {
        String name = "test";
        TeamMember teamMember = teamMemberMapper.selectOne(new QueryWrapper<TeamMember>().eq("name", name));
        long id = teamMember.getId();
        teamMember = teamMemberMapper.selectById(id);
        assert teamMember != null;
    }

    @Test
    @Order(3)
    void testFindByName(){
        String name = "test";
        TeamMember teamMember = teamMemberMapper.selectOne(new QueryWrapper<TeamMember>().eq("name", name));
        if (teamMember != null) {
            System.out.println(teamMember.getName());
        }
        assert teamMember != null;
    }

    @Test
    @Order(4)
    void testDeleteTeamMember(){
        String name = "test";
        TeamMember teamMember = teamMemberMapper.selectOne(new QueryWrapper<TeamMember>().eq("name", name));
        long id = teamMember.getId();
        teamMemberMapper.deleteById(id);
        teamMember = teamMemberMapper.selectById(id);
        assert teamMember == null;
    }

    /*
    select id, name, qq, position
    from TeamMembers
    where qq like 1 and qq >= 1;
     */
    @Test
    void testQueryWrapper(){
        QueryWrapper<TeamMember> queryWrapper = new QueryWrapper<TeamMember>()
                .select("id", "name", "qq", "position", "createtime")
                .like("qq", "1")
                .ge("qq", "1");
        List<TeamMember> teamMembers = teamMemberMapper.selectList(queryWrapper);
        teamMembers.forEach(System.out::println);
    }

    /*
    UPDATE TeamMembers
        SET qq = 1231312
        WHERE (username = "borgo");
     */
    @Test
     void testUpdateTeamMember(){
        TeamMember teamMember = new TeamMember();
        teamMember.setQq("1231312");
        QueryWrapper<TeamMember> queryWrapper = new QueryWrapper<TeamMember>()
                .eq("name", "borgo");
        int update = teamMemberMapper.update(teamMember, queryWrapper);
        assert update == 1;
    }

    @Test
    void testLambdaUpdateWrapper(){
        LambdaQueryWrapper<TeamMember> lambdaQueryWrapper = new LambdaQueryWrapper<TeamMember>()
                .select(TeamMember::getId, TeamMember::getName, TeamMember::getQq)
                .like(TeamMember::getName, "b")
                .le(TeamMember::getCreatetime, LocalDateTime.now());
        List<TeamMember> teamMembers = teamMemberMapper.selectList(lambdaQueryWrapper);
        teamMembers.forEach(System.out::println);
    }

    @Test
    void testUpdateWrapper(){
        List<Long> ids = List.of(9L, 10L, 11L);
        UpdateWrapper<TeamMember> updateWrapper = new UpdateWrapper<TeamMember>()
                .setSql("age = age -2")
                .in("id", ids);
        teamMemberMapper.update(updateWrapper);
    }
}
