package com.Web.GreatMing.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@TableName("`TeamMembers`")
@Data
public class TeamMember {

    // @NotNull
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String qq;

    private String gender;

    private int age;

    private String microphone;

    // 想去的兵营
    private String company;

    // 了解本队的方式
    private String know;

    // 时长
    private String timelength;

    // 性格
    private String disposition;

    // 在线时间
    private String timeonline;

    // 喜爱的游戏
    private String favoritegames;

    // 曾经隶属的战队
    @NotEmpty
    private String pastteams;

    // 给自己的定位
    private String position;

    // 遇到辱骂等行为时的行为
    private String behavior;

    private LocalDateTime createtime;

}