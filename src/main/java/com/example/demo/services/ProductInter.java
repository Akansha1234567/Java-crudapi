package com.example.demo.services;

import com.example.demo.models.Products;

import java.util.List;

public interface ProductInter {
    public List<Products> getProduct();
    public Products getOneProduct( Integer id);
    public String saveProduct(Products product);
    public String updateProduct(Integer id,Products product);
    public String deleteProduct(Integer id);

    public String updateSelectedProduct(Integer id, Products product);
}
