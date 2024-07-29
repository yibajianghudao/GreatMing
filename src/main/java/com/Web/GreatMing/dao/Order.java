package com.Web.GreatMing.dao;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Order {

    @NotNull
    private int id;

    @NotNull
    private int productId;

    @NotEmpty
    private String productName;

    @NotEmpty
    private String username;

    @NotNull
    private Double price;

    @NotNull
    private int quantity;

    private Double sum;


}
