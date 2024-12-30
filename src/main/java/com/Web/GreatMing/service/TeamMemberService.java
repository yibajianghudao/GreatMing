package com.Web.GreatMing.service;

import java.util.List;

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
        return teamMemberMapper.findAllTeamMember();
    }

    public TeamMember getTeamMemberById(long id){
        return teamMemberMapper.findTeamMemberById(id);
    }

    public String addTeamMember(TeamMember teamMember) throws MessageException{
        if ((teamMemberMapper.findTeamMemberByName(teamMember.getName()) != null)) {
            throw new MessageException("this name is be used.");
        }
        teamMemberMapper.addNewTeamMember(teamMember);
        TeamMember newtTeamMember = teamMemberMapper.findTeamMemberByName(teamMember.getName());
        if (newtTeamMember == null) {
            throw new MessageException("add teamMember failed.");
        } else {
            return "add teamMember success.";
        }
        
    }

    public String deleteTeamMember(long id) throws MessageException {
        teamMemberMapper.deleteTeamMemberById(id);
        if (teamMemberMapper.findTeamMemberById(id) != null) {
            throw new MessageException("delete teamMember failed.");
        }else{
            return "delete teamMember success.";
        }
    }
    
}
