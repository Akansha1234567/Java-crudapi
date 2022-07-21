package com.example.demo.services;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService implements ProductInter {

    @Autowired
    public com.example.demo.repo.ProductRepo ProductRepo;

    @Override

    public List<Products> getProduct() {
            return ProductRepo.findAll();
    }

    @Override
    public Products getOneProduct(Integer id) throws IdNotFoundException {
        Products product;
        if(ProductRepo.findById(id).isEmpty()){
            throw new IdNotFoundException();
        }
        else {
            product = ProductRepo.findById(id).get();
        }
        return product;
    }

    @Override
    public String saveProduct(Products product) {

        ProductRepo.save(product);
        return "Saved.....";
    }

    @Override
    public String updateProduct(Integer id, Products product) throws IdNotFoundException{

        if( ProductRepo.findById(id).isEmpty()){

            throw new IdNotFoundException();
        }
        else{
            Products updatedProduct = ProductRepo.findById(id).get();
            //updatedProduct.setCategoryId(product.getCategoryId());
            updatedProduct.setProductName(product.getProductName());
            updatedProduct.setProductDescription(product.getProductDescription());
            updatedProduct.setPrice(product.getPrice());
            //updatedProduct.setCreateDate(product.getCreateDate());

            updatedProduct.setUpdateDate(new Date(System.currentTimeMillis()));
            //updatedProduct.setUpdateDate(product.getUpdateDate());
            updatedProduct.setActive(product.getActive());
            updatedProduct.setDeleted(product.getDeleted());
            ProductRepo.save(updatedProduct);

            return "Updated Successfully";
        }
    }


    @Override
    public String deleteProduct(Integer id) throws IdNotFoundException {
        if(ProductRepo.findById(id).isEmpty()){
            throw new IdNotFoundException();
        }
        else {
            Products deleteProduct= ProductRepo.findById(id).get();
            ProductRepo.delete(deleteProduct);

            //ProductRepo.deleteById(id);
            return"User is deleted with id "+ id;
        }

    }

    @Override
    public String updateSelectedProduct(Integer id, Products product) throws IdNotFoundException{
        if(ProductRepo.findById(id).isEmpty()){
            throw new IdNotFoundException();
        }
        else {
            Products UpdateSelectedProduct = ProductRepo.findById(id).get();
            UpdateSelectedProduct.setProductName(product.getProductName());
            UpdateSelectedProduct.setProductDescription(product.getProductDescription());
            UpdateSelectedProduct.setPrice(product.getPrice());
            //updatedProduct.setCreateDate(product.getCreateDate());

            UpdateSelectedProduct.setUpdateDate(new Date(System.currentTimeMillis()));
            //updatedProduct.setUpdateDate(product.getUpdateDate());
            UpdateSelectedProduct.setActive(product.getActive());
            UpdateSelectedProduct.setDeleted(product.getDeleted());
            ProductRepo.save(UpdateSelectedProduct);
            return "Updated Successfully";
        }

    }
}
