package com.example.demo.controller;

import com.example.demo.models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllersCategory {

    @Autowired
    public com.example.demo.services.CategoryInter CategoryInter;
    Logger log = LoggerFactory.getLogger(ApiControllersCategory.class);

    @GetMapping(value = "/category")
    public List<Category> getCategory(){
        log.info("total categories listed");
        return CategoryInter.getCategory();
    }


    @GetMapping(value = "/category/{id}")
    public ResponseEntity getOneCategory(@PathVariable Integer id){
        return new ResponseEntity(CategoryInter.getOneCategory(id), HttpStatus.OK);
    }


    @PostMapping(value = "/category")
    public String saveCategory(@RequestBody Category category){
        return CategoryInter.saveCategory(category);
    }


    @PutMapping(value = "/category/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id,@RequestBody Category category ){
        return new ResponseEntity<>(CategoryInter.updateCategory(id,category),HttpStatus.OK);
    }

    @DeleteMapping(value = "/category/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id){
        return new ResponseEntity<>(CategoryInter.deleteCategory(id),HttpStatus.OK);
    }
}
