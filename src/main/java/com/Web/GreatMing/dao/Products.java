package com.Web.GreatMing.dao;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Products {
    @NotNull
    private int id;

    private String classification;

    @NotEmpty
    private String name;

    @NotNull
    private double price;

    @NotNull
    private int quantity;

    private String description;

    private String image_url;
}
