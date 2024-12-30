package com.Web.GreatMing.service;

import com.Web.GreatMing.dao.*;
import com.Web.GreatMing.exception.MessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductsMapper productsMapper;
    @Autowired
    private UserServiceimpl userServiceimpl;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ProductsService productsService;

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

    @Transactional  // 运行失败后回滚
    public Order buyOrder(String username, int productId, int quantity) {
        Order order1 = new Order();
        long userid = userServiceimpl.findByName(username).getId();
        // 获取商品对象
        Products products = productsMapper.findByid(productId);
        String productName = products.getName();

        double price = products.getPrice();
        double sum = price * quantity;

        boolean status = userServiceimpl.reduceBalance(userid, price);
        if (status) {
            // 构建订单信息
            order1.setUsername(username);
            order1.setProductId(productId);
            order1.setProductName(productName);
            order1.setPrice(products.getPrice());
            order1.setQuantity(quantity);
            order1.setSum(sum);
            orderMapper.addOrder(order1);
            productsService.updateProductsQuantity(productId, (quantity * -1));
            return orderMapper.findLastByUsername(username);
        } else {
            throw new MessageException("balance isn't enough");
        }
    }

    @Transactional
    public double refundOrder(long id) {
        Order order = orderMapper.findById(id);
        User user = userServiceimpl.findByName(order.getUsername());
        long userid = user.getId();
        boolean status = userServiceimpl.addBalance(userid, order.getSum());
        if (status) {
            orderMapper.deleteById(id);
            return usersMapper.findUserById(userid).getBalance();
        } else {
            throw new MessageException("balance isn't be refund");
        }
    }
}
