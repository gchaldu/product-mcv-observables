package com.gchaldu.category.controller;

import com.gchaldu.category.excepciones.ExistCategoryException;
import com.gchaldu.category.model.entity.Category;
import com.gchaldu.category.model.repository.CategoryRepository;

public class CategoryController {

    private CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category add(String name){
        Category category = new Category(name);
        try {
            repository.getCategoryByName(name);
            repository.add(category);
        } catch (ExistCategoryException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    public CategoryRepository getRepository() {
        return repository;
    }
}
