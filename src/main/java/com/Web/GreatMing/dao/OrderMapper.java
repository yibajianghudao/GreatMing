package com.Web.GreatMing.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper()
public interface OrderMapper {

    @Select("select * from orders")
    List<Order> findAllOrder();

    @Select("select * from orders where id=#{id}")
    Order findById(long id);

    @Delete("delete from orders where id=#{id}")
    void deleteById(long id);

    @Insert("insert into orders(productId,productName,username,price,quantity,sum) values (#{productId},#{productName},#{username},#{price},#{quantity},#{sum})")
    void addOrder(Order order);
}
