package com.Web.GreatMing.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Web.GreatMing.dao.GameHandleLog;
import com.Web.GreatMing.dao.GreatMingLog;

@Component()
public class ReadHandleLog {

    @Autowired
    private ReadGameLog readGameLog;

    public List<GreatMingLog> ReadLog(GameHandleLog log){
        LocalDate date = log.getDate();
        StringReader alllineReader = new StringReader(log.getData());
        BufferedReader reader = new BufferedReader(alllineReader);
        Map<String, Integer> result = new HashMap<>();
        String line;
        try{
            while ((line = reader.readLine()) != null) {
                //  JiangHuDao 5
                String[] lineStrings = line.split(" ");
                if (lineStrings.length >= 2) {
                    String name = lineStrings[0];
                    int kills = Integer.parseInt(lineStrings[1]);
                    result.put(name, kills);
                }
            }
        }catch (IOException e){
            System.out.println("读取字符串内容失败");
        }

        return readGameLog.ReadMapToGreatMingLog(date, result);
        
    }
}
