package com.Web.GreatMing.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Web.GreatMing.dao.GameHandleLog;
import com.Web.GreatMing.dao.GameLog;
import com.Web.GreatMing.dao.GreatMingLog;
import com.Web.GreatMing.dao.GreatMingLogMapper;
import com.Web.GreatMing.dao.MonthLog;
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

    @Autowired
    private ToolsService toolsService;

    @Autowired
    private UserService userService;

    @Transactional
    public String uploadGameLog(GameLog gameLog) throws MessageException {
        try {
            List<GreatMingLog> list = readGameLog.ReadLog(gameLog);
            int length = list.size();
            for (GreatMingLog greatMingLog : list) {
                greatMingLogMapper.addGreatMingLog(greatMingLog);
            }
            return length + "";
        } catch (Exception e) {
            throw new MessageException("add GreatMingLog fail.");
        }
    }

    @Transactional
    public String uploadHandleGameLog(GameHandleLog gameHandleLog) throws MessageException {
        try {
            List<GreatMingLog> list = readHandleLog.ReadLog(gameHandleLog);
            int length = list.size();
            for (GreatMingLog greatMingLog : list) {
                greatMingLogMapper.addGreatMingLog(greatMingLog);
            }
            return length + "";
        } catch (Exception e) {
            throw new MessageException("add GreatMingLog fail.");
        }
    }

    public List<GreatMingLog> getAllGameLogs() {
        return greatMingLogMapper.selectAllGreatMingLogs();
    }

    public GreatMingLog getGameLogsById(long id) {
        return greatMingLogMapper.findGreatMingLogsById(id);
    }

    public List<GreatMingLog> getGameLogsByDateName(String name) {
        return greatMingLogMapper.findGreatMingLogsByName(name);
    }

    public List<GreatMingLog> getGameLogsByDateName(LocalDate date) {
        return greatMingLogMapper.findGreatMingLogsByDate(date);
    }

    public List<GreatMingLog> getGameLogsByDateName(LocalDate date, String name) {
        return greatMingLogMapper.findGreatMingLogsByDateName(date, name);
    }

    public Map<String, MonthLog> CountMouthLogs(int year, int month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        List<GreatMingLog> GreatMingLogs = toolsService.findGreatMingLogsByDateRange(startDate, endDate);
        Map<String, MonthLog> monthMap = new HashMap<String, MonthLog>();
        for (GreatMingLog greatMingLog : GreatMingLogs) {
            String name = greatMingLog.getName();
            if (userService.findByName(name) != null) {
                if (!monthMap.containsKey(name)) {
                    MonthLog monthLog = new MonthLog();
                    monthLog.setName(name);
                    monthLog.setCompany(userService.findByName(name).getCompany());
                    monthLog.setAttendance(1);
                    monthLog.setKills(greatMingLog.getKills());
                    // 此处不设置balance，等全部数据集合完毕后计算军饷
                    monthLog.setDescription(String.format("At %s attendance with kills %d.", greatMingLog.getDate(),
                            greatMingLog.getKills()));
                    monthMap.put(name, monthLog);

                } else {
                    MonthLog monthLog = monthMap.get(name);
                    monthLog.setAttendance(monthLog.getAttendance() + 1);
                    monthLog.setKills(monthLog.getKills() + greatMingLog.getKills());
                    monthLog.setDescription(monthLog.getDescription() + String.format("At %s attendance with kills %d.",
                            greatMingLog.getDate(), greatMingLog.getKills()));
                    monthMap.put(name, monthLog);
                }
            }

        }
        int SJPKills = 0;
        // 计算神机炮总击杀
        for (Entry<String, MonthLog> monthEntry : monthMap.entrySet()) {
            MonthLog monthLog = monthEntry.getValue();
            if (monthLog.getCompany().equals("SJP")) {
                SJPKills += monthLog.getKills();
            }
        }
        // 计算军饷
        for (Entry<String, MonthLog> monthEntry : monthMap.entrySet()) {
            String name = monthEntry.getKey();
            MonthLog monthLog = new MonthLog();
            monthLog = monthEntry.getValue();
            MonthLog countedMonthlog = CountBalance(monthLog, SJPKills);
            if (countedMonthlog != null) {
                monthMap.put(name, countedMonthlog);
            } else {
                continue;
            }

        }

        return monthMap;
    }

    private MonthLog CountBalance(MonthLog monthLog, int SJPKills) {
        String company = monthLog.getCompany();
        int kills = monthLog.getKills();
        int attendance = monthLog.getAttendance();
        double balannce = 0;
        switch (company) {
            case "WJ":
                if (kills >= 30) {
                    balannce += 1.0;
                }
                break;

            case "SJ":
                if (kills >= 30) {
                    balannce += 1.0;
                }
                break;
            case "SQ":
                if (kills >= 50) {
                    balannce += 1.0;
                }
                break;
            case "SJP":
                if (SJPKills >= 120) {
                    balannce += 1.0;
                }
                break;
            default:
                return null;

        }
        if (attendance >= 3 && attendance < 6) {
            balannce += 1;
        } else if (attendance >= 6 && attendance < 8) {
            balannce += 2;
        } else if (attendance >= 8) {
            balannce += 3;
        }
        monthLog.setBalance(balannce);
        return monthLog;
    }

}