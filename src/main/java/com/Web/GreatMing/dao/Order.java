package com.Web.GreatMing.dao;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Order {

    @NotNull
    private int id;

    @NotNull
    private int productId;

    @NotEmpty
    private String productName;

//    @NotEmpty // 购买的时候通过token读出name即可
    private String username;

    @NotNull
    private double price;

    @NotNull
    private int quantity;

    private double sum;

    private LocalDateTime createTime;


}
