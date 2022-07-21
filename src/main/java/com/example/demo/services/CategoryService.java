package com.example.demo.services;

import com.example.demo.controller.ApiControllersCategory;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.models.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements CategoryInter {
    @Autowired
    public com.example.demo.repo.CategoryRepo CategoryRepo;

    Logger log = LoggerFactory.getLogger(CategoryService.class);

    @Override
    public List<Category> getCategory() {
        return CategoryRepo.findAll();
    }



    @Override
    public Category getOneCategory(Integer id) throws IdNotFoundException {
        Category category =null;

        if(CategoryRepo.findById(id).isEmpty()){
            log.error("id doesnt exist");
            throw new IdNotFoundException();
        }
        else{
             category = CategoryRepo.findById(id).get();
            return category;
        }

    }

    @Override
    public String updateCategory(Integer id, Category category) throws IdNotFoundException {
        if(CategoryRepo.findById(id).isEmpty()){
            throw new IdNotFoundException();
        }
        else {
            Category updatedCategory = CategoryRepo.findById(id).get();
            updatedCategory.setCategoryName(category.getCategoryName());
            updatedCategory.setCategoryDescription(category.getCategoryDescription());
            // updatedCategory.setCreateDate(category.getCreateDate());
            updatedCategory.setUpdateDate(category.getUpdateDate());
            updatedCategory.setActive(category.getActive());
            updatedCategory.setDeleted(category.getDeleted());
            CategoryRepo.save(updatedCategory);
            return "Updated Successfully...";
        }

    }

    @Override
    public String deleteCategory(Integer id) throws IdNotFoundException {
        if(CategoryRepo.findById(id).isEmpty()){
            throw new IdNotFoundException();
        }
        else {
            Category category = CategoryRepo.findById(id).get();
            CategoryRepo.delete(category);
            return "Category is deleted with id :" + id;
        }

    }


    @Override
    public String saveCategory(Category category) {
        CategoryRepo.save(category);
        return "Saved...";
    }











}
