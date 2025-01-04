package com.Web.GreatMing.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.Web.GreatMing.dao.GameLog;
import com.Web.GreatMing.dao.GreatMingLog;

@Component()
public class ReadGameLog {
    public List<GreatMingLog> ReadLog(GameLog log) {

        LocalDate date = log.getDate();
        String language = log.getLanguage();
        StringReader alllineReader = new StringReader(log.getData());
        BufferedReader reader = new BufferedReader(alllineReader);
        Map<String, Integer> result = new HashMap<>();
        String line;
        try{
            while ((line = reader.readLine()) != null) {
                //  18:02:20 - GreatMing_SJ_smnz_YB[III] <img=ico_crossbow> 74thPGC_UEST_LLL
                String[] lineList = line.split(" ");
                if (lineList.length > 3 && lineList[3].startsWith("GreatMing")) {
                    try {
                        String[] nameList = lineList[3].split("_");
                        // String group = nameList[1];
                        String name = getNameFromLineList(nameList);
                        // 是击杀的数据才统计，排除tk数据
                        if (!name.equals("")  && lineList[4].startsWith("<")) {
                            result.putIfAbsent(name, 0);
                            result.put(name, result.get(name) + 1);
                        }
                        String tk = findTK(line);
                        if (!tk.equals("")) {
                            result.put(tk, result.get(tk) - 1);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("处理行出错: "+line);
                    }
                }
            }
        }catch (IOException e){
            System.out.println("读取字符串内容失败");
        }

        return ReadMapToGreatMingLog(date, result);
    }

    
    //str_ch=" 20:07:25 - 74th_KnWe_dunh[kfive]误 杀 7PUSL_IV_RN_Sierz_BT。  "
    //str_ch_mount=" 20:07:18 - 25thNIR_inf_Rec_FA误 杀 18thRUG_2Lt_genossen的 马 。  "
    public String findTK(String line){
        String name = "";
        if (line.contains("误 杀") && !line.contains("马")) {
            String[] nameList = line.split(" ")[3].replace("误", "").split("_");
            name = getNameFromLineList(nameList);
        }
        return name;
    }

    public String getNameFromLineList(String[] nameList) {
        String name = "";
        if (nameList.length >= 4) {
            name = nameList.length > 4 ? nameList[2] + "_" + nameList[3] : nameList[2];
        }
        return name;
    }

    public List<GreatMingLog> ReadMapToGreatMingLog(LocalDate date, Map<String, Integer> resultMap){
        List<GreatMingLog> GreatMingLogList = new ArrayList<>();
        for (String name : resultMap.keySet()) {
            GreatMingLog log = new GreatMingLog();
            log.setDate(date);
            log.setName(name);
            log.setKills(resultMap.get(name));
            GreatMingLogList.add(log);
        }
        return GreatMingLogList;
    }
}
