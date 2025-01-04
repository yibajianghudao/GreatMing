package com.Web.GreatMing.dao;

import lombok.Data;
import java.time.LocalDate;
import jakarta.validation.constraints.NotEmpty;

@Data
public class GameHandleLog {

    private long id;

    @NotEmpty
    private LocalDate date;

    @NotEmpty
    private String data;

}
