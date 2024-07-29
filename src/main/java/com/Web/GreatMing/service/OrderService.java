package com.Web.GreatMing.service;

import com.Web.GreatMing.dao.Order;
import com.Web.GreatMing.dao.OrderMapper;
import com.Web.GreatMing.dao.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getAllOrder() {
        return orderMapper.findAllOrder();
    }

    public Order addOrder(Order order) {
        orderMapper.addOrder(order);
        return orderMapper.findById(order.getId());
    }

    public Order findById(long id) {
        return orderMapper.findById(id);
    }

    public void delOrder(long id) {
        orderMapper.deleteById(id);
    }
}
