package com.Web.GreatMing.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper()
public interface ProductsMapper {
    @Select("select * from Products")
    List<Products> selectAllProducts();

    @Select("select * from Products where id=#{id}")
    Products findByid(long id);

    @Delete("delete from Products where id=#{id}")
    void deleteById(long id);

    @Insert("insert into Products(name, classification, price, quantity,description,image_url) values(#{name},#{classification},#{price}, #{quantity}, #{description}, #{image_url})")
    void addProducts(Products products);

    @Select("select * from Products where name=#{name}")
    Products findByName(String name);

    @Update("update Products set name=#{name},classification=#{classification},price=#{price},quantity=#{quantity},description=#{description},image_url=#{image_url} where id=#{id}")
    void updateProducts(Products products);

    @Update("update Products set quantity=#{quantity} where id=#{id}")
    void updateProductsQuantity(long id, int quantity);
}
