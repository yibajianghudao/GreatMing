package com.Web.GreatMing.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper()
public interface OrderMapper {

    @Select("select * from orders")
    List<Order> findAllOrder();

    @Select("select * from orders where id=#{id}")
    Order findById(long id);

    @Delete("delete from orders where id=#{id}")
    void deleteById(long id);

    @Insert("insert into orders(productId,productName,username,price,quantity,sum,createTime) values (#{productId},#{productName},#{username},#{price},#{quantity},#{sum},now())")
    void addOrder(Order order);

    @Select("select * from orders where id=(select max(id) from orders where username=#{username})")
    Order findLastByUsername(String username);
}
