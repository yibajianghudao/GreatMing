package com.Web.GreatMing.controller;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.dao.Order;
import com.Web.GreatMing.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/addorder")
    public Response<?> addOrder(@RequestBody @Validated Order order) {
        Order order1 = orderService.addOrder(order);
        return Response.newSuccess(order1, "add order success");
    }

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

}
