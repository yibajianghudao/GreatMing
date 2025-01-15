package com.Web.GreatMing.dao;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BalanceUpdate {
    
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private boolean isadd;

    @NotEmpty
    private double balance;

    @NotEmpty
    private String description;

    private double updatedbalance;

    private LocalDate updatetime;

}
