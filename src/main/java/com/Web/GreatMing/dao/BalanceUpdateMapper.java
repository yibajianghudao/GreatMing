package com.Web.GreatMing.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BalanceUpdateMapper {

    @Select("SELECT * FROM BalanceUpdates")
    List<BalanceUpdate> findAllBalanceUpdates();

    @Select("SELECT * FROM BalanceUpdates WHERE id = #{id}")
    BalanceUpdate findById(long id);

    @Select("SELECT * FROM BalanceUpdates WHERE name = #{name}")
    List<BalanceUpdate> findByName(String name);

    @Delete("DELETE FROM BalanceUpdates WHERE id = #{id}")
    void deleteById(long id);

    @Insert("INSERT INTO BalanceUpdates(name, isadd, balance,updatedbalance,  description, updatetime) VALUES (#{name}, #{isadd}, #{balance}, #{updatedbalance}, #{description}, now())")
    int addBalanceUpdate(BalanceUpdate balanceUpdate);

    // @Select("SELECT * FROM BalanceUpdates WHERE id = (SELECT MAX(id) FROM BalanceUpdates WHERE name = #{name})")
    // BalanceUpdate findLastByName(String name);
}
