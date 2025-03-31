package com.Web.GreatMing.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class TeamMemberMapperTest {

    @Autowired
    private TeamMemberMapper teamMemberMapper;

    @Test
    public void testAddTeamMember() {
        TeamMember teamMember = new TeamMember();
        teamMember.setName("test");
        teamMember.setQq("111111111");
        teamMember.setPosition("无");
        teamMember.setCreatetime(LocalDateTime.now());
        teamMemberMapper.insert(teamMember);

    }


    @Test
    public void testFindByTeamId()  {
        long id = 1L;
        TeamMember teamMember = teamMemberMapper.selectById(id);
        assert teamMember != null;
    }

    @Test
    public void testFindByName(){
        String name = "test";
        TeamMember teamMember = teamMemberMapper.selectOne(new QueryWrapper<TeamMember>().eq("name", name));
        if (teamMember != null) {
            System.out.println(teamMember.getName());
        }
        assert teamMember != null;
    }

}
