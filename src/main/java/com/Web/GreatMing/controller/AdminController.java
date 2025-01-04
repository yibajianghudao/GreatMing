package com.Web.GreatMing.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.dao.GameLog;
import com.Web.GreatMing.dao.GreatMingLog;
import com.Web.GreatMing.exception.MessageException;
import com.Web.GreatMing.service.AdminService;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/Admin")

public class AdminController {
    
    @Autowired
    private AdminService adminService;

    @PostMapping("/uploadGameLog")
    public Response<?> uploadGameLog(@RequestBody GameLog gameLog) {
        try {
            String msg = adminService.uploadGameLog(gameLog);
            return Response.newSuccess("add "+ msg + " GreatMingLog.");
        } catch (MessageException e) {
            return Response.newFail(e.getMessage());
        }
        
    }

    @GetMapping("/getGameLogs")
    public Response<?> GetGameLogsByName(@RequestParam String name, @RequestParam String date, @RequestParam String id) {

        
        if (String.valueOf(id)!="") {
            long id2 = Long.parseLong(id);
            GreatMingLog data = adminService.getGameLogsById(id2);
            return Response.newSuccess(data, "get GameLogs success!");
        }else if (name!=""&& date.toString()=="") {
            List<GreatMingLog> data = adminService.getGameLogsByDateName(name);
            return Response.newSuccess(data, "get GameLogs success!");
        }else if (name==""&& date.toString()!="") {
            LocalDate localDate = LocalDate.parse(date);
            List<GreatMingLog> data = adminService.getGameLogsByDateName(localDate);
            return Response.newSuccess(data, "get GameLogs success!");
        }else if (name!=""&& date.toString()!="") {
            LocalDate localDate = LocalDate.parse(date);
            List<GreatMingLog> data = adminService.getGameLogsByDateName(localDate, name);
            return Response.newSuccess(data, "get GameLogs success!");
        }else{
            return Response.newFail("At least one parameter given.");
        }
        
    }
    
    

}
