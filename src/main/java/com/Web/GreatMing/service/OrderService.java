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
    private UserService userServiceimpl;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ProductsService productsService;

    @Autowired
        BalanceUpdateService balanceUpdateService;

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
    public String buyOrder(String username, int productId, int quantity)throws MessageException {
        Order order1 = new Order();
        // 获取商品对象
        Products products = productsMapper.findByid(productId);
        // 判断商品数量是否足够
        int productQuantity = products.getQuantity();
        if (productQuantity < quantity) {
            throw new MessageException("product quantity is not enough.");
        }

        String productName = products.getName();
        double price = products.getPrice();
        double sum = price * quantity;

        // 构建更新军饷表单
        BalanceUpdate balanceUpdate = new BalanceUpdate();
        balanceUpdate.setBalance(sum);
        balanceUpdate.setName(username);
        balanceUpdate.setIsadd(false);
        balanceUpdate.setDescription("buy "+productName + "* " + quantity);
        // 更新表单
        balanceUpdateService.addBalanceUpdate(balanceUpdate);
        // 构建订单信息
        order1.setUsername(username);
        order1.setProductId(productId);
        order1.setProductName(productName);
        order1.setPrice(products.getPrice());
        order1.setQuantity(quantity);
        order1.setSum(sum);
        // 添加订单
        orderMapper.addOrder(order1);
        // 更新商品数量
        productsService.updateProductsQuantity(productId, (quantity * -1));
        return "create buyOrder success.";
    }

    @Transactional
    public String refundOrder(long id) throws MessageException {
        Order order = orderMapper.findById(id);

        BalanceUpdate balanceUpdate = new BalanceUpdate();
        balanceUpdate.setBalance(order.getSum());
        balanceUpdate.setName(order.getUsername());
        balanceUpdate.setIsadd(true);
        balanceUpdate.setDescription("refund product: "+order.getProductName() + "* " + order.getQuantity());

        balanceUpdateService.addBalanceUpdate(balanceUpdate);

        // boolean status = userServiceimpl.addBalance(userid, order.getSum());
        orderMapper.deleteById(id);
        if (orderMapper.findById(id)==null) {
            return "delete order success.";
        }else{
            throw new MessageException("delete order failed.");
        }
        
    }
}
