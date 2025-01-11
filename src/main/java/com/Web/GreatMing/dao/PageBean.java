package com.Web.GreatMing.dao;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean <T> {
    private Long total;
    private List<T> items;
    private int pages;

    
}
