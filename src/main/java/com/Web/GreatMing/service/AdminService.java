package com.Web.GreatMing.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Web.GreatMing.dao.GameHandleLog;
import com.Web.GreatMing.dao.GameLog;
import com.Web.GreatMing.dao.GreatMingLog;
import com.Web.GreatMing.dao.GreatMingLogMapper;
import com.Web.GreatMing.exception.MessageException;
import com.Web.GreatMing.utils.ReadGameLog;
import com.Web.GreatMing.utils.ReadHandleLog;

@Service
public class AdminService {
    @Autowired
    private ReadGameLog readGameLog;

    @Autowired
    private ReadHandleLog readHandleLog;

    @Autowired
    private GreatMingLogMapper greatMingLogMapper;
    
    @Transactional
    public String uploadGameLog(GameLog gameLog) throws MessageException{
        try {
            List<GreatMingLog> list = readGameLog.ReadLog(gameLog);
            int length = list.size();
            for (GreatMingLog greatMingLog : list) {
                greatMingLogMapper.addGreatMingLog(greatMingLog);
            }
            return length+"";
        } catch (Exception e) {
            throw new MessageException("add GreatMingLog fail.");
        }
    }

    @Transactional
    public String uploadHandleGameLog(GameHandleLog gameHandleLog) throws MessageException{
        try {
            List<GreatMingLog> list = readHandleLog.ReadLog(gameHandleLog);
            int length = list.size();
            for (GreatMingLog greatMingLog : list) {
                greatMingLogMapper.addGreatMingLog(greatMingLog);
            }
            return length+"";
        } catch (Exception e) {
            throw new MessageException("add GreatMingLog fail.");
        }
    }

    public List<GreatMingLog> getAllGameLogs(){
        return greatMingLogMapper.selectAllGreatMingLogs();
    }

    public GreatMingLog getGameLogsById(long id){
        return greatMingLogMapper.findGreatMingLogsById(id);
    }

    public List<GreatMingLog> getGameLogsByDateName(String name){
        return greatMingLogMapper.findGreatMingLogsByName(name);
    }

    public List<GreatMingLog> getGameLogsByDateName(LocalDate date){
        return greatMingLogMapper.findGreatMingLogsByDate(date);
    }

    public List<GreatMingLog> getGameLogsByDateName(LocalDate date, String name){
        return greatMingLogMapper.findGreatMingLogsByDateName(date, name);
    }
}