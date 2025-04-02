package com.Web.GreatMing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.dao.TeamMember;
import com.Web.GreatMing.exception.MessageException;
import com.Web.GreatMing.service.TeamMemberService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController()
@RequestMapping("/teammember")
public class TeamMemberController {

    @Autowired
    private TeamMemberService teamMemberService;

    @GetMapping("/all")
    public Response<List<TeamMember>> getAllTeamMember() {
        return Response.newSuccess(teamMemberService.getAllTeamMember(), "get all TeamMember success!");
    }
    
    @PostMapping("/add")
    public Response<?> addNewTeamMember(@RequestBody TeamMember teamMember) {
        try {
            String msg = teamMemberService.addTeamMember(teamMember);     
            return Response.newSuccess(msg);
        } catch (MessageException e) {
            return Response.newFail(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response<?> deleteTeamMember(@PathVariable Long id){
        try {
            String msg = teamMemberService.deleteTeamMember(id);
            return Response.newSuccess(msg);
        } catch (MessageException e) {
            return Response.newFail(e.getMessage());
        }
    }
    

}
