package com.Web.GreatMing.service;

import com.Web.GreatMing.dao.Products;
import com.Web.GreatMing.dao.ProductsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductsMapper productsMapper;


    public List<Products> getAllProducts() {
        return productsMapper.selectAllProducts();
    }

    public void deleteProductsById(long id) {
        Products products = productsMapper.findByid(id);
        if(products == null) throw new NullPointerException();
        productsMapper.deleteById(id);
    }

    public void addProducts(Products products) {
        productsMapper.addProducts(products);
    }

    public Products findByName(String name) {
        return productsMapper.findByName(name);
    }

    public Products updateProducts(Products products) {
        try {
            Products products1 = productsMapper.findByid(products.getId());
            if (products.getName()!=null) products1.setName(products.getName());
            if (products.getDescription()!=null) products1.setDescription(products.getDescription());
            if (products.getClassification()!=null) products1.setClassification(products.getClassification());
            if (products.getPrice()!=0) products1.setPrice(products.getPrice());
            if (products.getImage_url()!=null) products1.setImage_url(products.getImage_url());
            if (products.getQuantity()!=0) products1.setQuantity(products.getQuantity());
            productsMapper.updateProducts(products1);
            return productsMapper.findByid(products.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int updateProductsQuantity(long id, int quantity) {
        int quantity1 = productsMapper.findByid(id).getQuantity() + quantity;
        productsMapper.updateProductsQuantity(id, quantity1);
        return productsMapper.findByid(id).getQuantity();
    }
}
