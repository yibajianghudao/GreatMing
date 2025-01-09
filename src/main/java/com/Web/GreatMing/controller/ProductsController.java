package com.Web.GreatMing.controller;

import com.Web.GreatMing.Response;
import com.Web.GreatMing.dao.Products;
import com.Web.GreatMing.service.ProductsService;
import com.Web.GreatMing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;
    @Autowired
    private UserService userServiceimpl;

    @GetMapping("/getallproducts")
    public Response<?> getAllProducts() {
        return Response.newSuccess(productsService.getAllProducts(), "返回所有商品信息成功");
    }

    @DeleteMapping("/delproducts/{id}")
    public Response<?> delProducts(@PathVariable long id) {
        try {
            productsService.deleteProductsById(id);
            return Response.newSuccess("删除成功");
        } catch (NullPointerException e) {
            return Response.newFail(id, "this id isn't exist.");
        }
    }

    @PostMapping("/addproducts")
    public Response<?> addProducts(@RequestBody Products products) {
        Products products1 = productsService.findByName(products.getName());
        if (products1 != null){
            return Response.newFail(products.getName(),"This name already exist");
        }
        productsService.addProducts(products);
        Products products2 = productsService.findByName(products.getName());
        if (products2 != null) {
            return Response.newSuccess("Add Products Success");
        } else {
            return Response.newFail("Add Products Fail");
        }

    }

    @PutMapping("/updateproducts")
    public Response<?> updateProducts(@RequestBody @Validated Products products) {
        Products newProducts = productsService.updateProducts(products);
        if (newProducts != null) {
            return Response.newSuccess(newProducts, "Update Products Success");

        }else {
            return Response.newFail("Update Products Fail");
        }
    }







}
