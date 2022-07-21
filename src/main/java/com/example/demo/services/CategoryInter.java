package com.example.demo.services;

import com.example.demo.models.Category;

import java.util.List;

public interface CategoryInter {
    public List<Category> getCategory();

    public String saveCategory(Category category);

    public Category getOneCategory(Integer id);

    public String updateCategory(Integer id,Category category );

    String deleteCategory(Integer id);
}
