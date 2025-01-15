package com.Web.GreatMing.controller;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.dao.Order;
import com.Web.GreatMing.exception.MessageException;
import com.Web.GreatMing.service.OrderService;
import com.Web.GreatMing.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getall")
    public Response<?> getAllOrder() {
        List<Order> list = orderService.getAllOrder();
        return Response.newSuccess(list, "find all orders success");
    }

    // 测试使用
    @PostMapping("/addorder")
    public Response<?> addOrder(@RequestBody @Validated Order order) {
        Order order1 = orderService.addOrder(order);
        return Response.newSuccess(order1, "add order success");
    }

    // 测试使用
    @DeleteMapping("/delorder/{id}")
    public Response<?> delOrder(@PathVariable long id) {
        orderService.delOrder(id);
        if (orderService.findById(id) == null) {
            return Response.newSuccess("delete order success");
        }
        else {
            return Response.newFail("del order fail");
        }
    }

    @PostMapping("/buy")
    public Response<?> buyOrder(@RequestBody Map<String, Integer> params) {
        try {
            int productId = params.get("productId");
            int quantity = params.get("quantity");
            Map<String, Object> map = ThreadLocalUtil.get();
            String name = (String) map.get("name");
            // 传入参数:productId,quantity
            // 没有检测剩余商品数量
            return Response.newSuccess(orderService.buyOrder(name, productId, quantity));
        } catch (MessageException e){
            return Response.newFail(e.getMessage());
        }

    }

    @DeleteMapping("/refund/{id}")
    public Response<?> refundOrder(@PathVariable long id) {
        try {
            return Response.newSuccess(orderService.refundOrder(id));
        } catch (MessageException e){
            return Response.newFail(e.getMessage());
        }

    }

}
