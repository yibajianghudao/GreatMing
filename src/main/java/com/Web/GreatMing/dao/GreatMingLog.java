package com.Web.GreatMing.dao;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class GreatMingLog {
    
    private long id;

    @NotEmpty
    private LocalDate date;

    @NotEmpty
    private String name;

    @NotEmpty
    private int kills;

}
