package com.Web.GreatMing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Web.GreatMing.dao.GameLog;
import com.Web.GreatMing.dao.GreatMingLog;
import com.Web.GreatMing.utils.ReadGameLog;

@SpringBootTest
public class ReadGameLogTest {
    
    @Autowired
    private ReadGameLog readGameLog;

    @Test
    public void getNameFromLineListTest(){
        String str1 = "GreatMing_SQ_hake_QH";
        String[] str1list = str1.split("_");
        assert readGameLog.getNameFromLineList(str1list).equals("hake");
        String str2 = "GreatMing_SQ_C_hake_QH";
        String[] str2list = str2.split("_");
        assert readGameLog.getNameFromLineList(str2list).equals("C_hake");

    }

    @Test
    public void findTKTest(){
        String str1 = " 20:07:25 - GreatMing_WS_testname_LY误 杀 7PUSL_IV_RN_Sierz_BT。  ";
        assert readGameLog.findTK(str1).equals("testname");
        String str2 = " 20:07:25 - GreatMing_WS_testname_LY误 杀 18thRUG_2Lt_genossen的 马 。  ";
        assert readGameLog.findTK(str2).equals("");
    }

    @Test
    public void ReadMapToGreatMingLogTest(){
        Map<String, Integer> result = new HashMap<>();
        result.put("name1", 10);
        result.put("name2", 20);
        LocalDate date = LocalDate.parse("2024-01-01");
        List<GreatMingLog> logList = readGameLog.ReadMapToGreatMingLog(date, result);
        System.out.println(logList.get(0));
    }

    @Test
    public void ReadLogTest(){
        GameLog log = new GameLog();
        log.setDate(LocalDate.parse("2024-01-01"));
        log.setLanguage("chinese");
        String logString = " 20:36:26 - GreatMing_SJ_bloeall_I <img=ico_crossbow> 74SiantBH_Sheperd "+
                        " 20:36:30 - GreatMing_ws_lyc_ly <img=ico_crossbow> 74thPGC_Nigger_MUR "+
                        " 20:36:35 - GreatMing_SQ_C_hake_JYW <img=ico_spear> ILCN_ZhangWeiwei"+
                        " 20:36:42 - GreatMing_SJ_bloeall_I <img=ico_spear> 18thRUG_Pfc_aizi "+
                        " 20:36:42 - GreatMing_SJ_bloeall_I误 杀 18thRUG_Pfc_aizi。 "+
                        " 20:36:45 - GreatMing_SQ_C_hake_JYW <img=ico_couchedlance> 74thPGC_Nigger_MUR "+
                        " 20:36:47 - GreatMing_SJ_bloeall_I <img=ico_spear> 95thKGL_Maj_Fatih ";
        String logString2 = " 20:36:26 - GreatMing_SJ_bloeall_I <img=ico_crossbow> 74SiantBH_Sheperd ";
        log.setData(logString2);
        List<GreatMingLog> GreatMingLogList = readGameLog.ReadLog(log);
        System.out.println(GreatMingLogList);
    }
}
