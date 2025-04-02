package com.Web.GreatMing.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Web.GreatMing.dao.TeamMember;
import com.Web.GreatMing.dao.TeamMemberMapper;
import com.Web.GreatMing.exception.MessageException;

@Service
public class TeamMemberService {

    @Autowired
    private TeamMemberMapper teamMemberMapper;

    public List<TeamMember> getAllTeamMember() {
        return teamMemberMapper.selectList(null);
    }

    public TeamMember getTeamMemberById(Long id){
        return teamMemberMapper.selectById(id);
    }

    public String addTeamMember(TeamMember teamMember) throws MessageException{
        if ((teamMemberMapper.selectOne(new QueryWrapper<TeamMember>().eq("name", teamMember.getName())) != null)) {
            throw new MessageException("this name is be used.");
        }
        teamMemberMapper.insert(teamMember);
        TeamMember newtTeamMember = teamMemberMapper.selectOne(new QueryWrapper<TeamMember>().eq("name", teamMember.getName()));
        if (newtTeamMember == null) {
            throw new MessageException("add teamMember failed.");
        } else {
            return "add teamMember success.";
        }
        
    }

    public String deleteTeamMember(Long id) throws MessageException {
        teamMemberMapper.deleteById(id);
        if (teamMemberMapper.selectById(id) != null) {
            throw new MessageException("delete teamMember failed.");
        }else{
            return "delete teamMember success.";
        }
    }
    
}
