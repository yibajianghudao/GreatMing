package com.Web.GreatMing.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Web.GreatMing.dao.GreatMingLog;
import com.Web.GreatMing.dao.GreatMingLogMapper;
import com.Web.GreatMing.exception.MessageException;

@Service
public class ToolsService {
    
    @Autowired
    private GreatMingLogMapper greatMingLogMapper;

    List<GreatMingLog> findGreatMingLogsByDateRange(LocalDate startDate, LocalDate endDate){
        if (startDate.isBefore(endDate)) {
            List<GreatMingLog> GreatMingLogs =  greatMingLogMapper.findGreatMingLogsByDateRange(startDate, endDate);
            return GreatMingLogs;
        }else{
            throw new MessageException("the startDate isn't befored endDate! find failed.");
        }
    }
}
