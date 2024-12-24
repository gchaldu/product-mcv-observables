package com.gchaldu.category.model.repository;

import com.gchaldu.category.excepciones.ExistCategoryException;
import com.gchaldu.category.model.entity.Category;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryRepository {

    private final List<Category> categories = new ArrayList<>();
    private final PublishSubject<List<Category>> publishSubject = PublishSubject.create();

    public void add(Category category){
        categories.add(category);
        publishSubject.onNext(categories);
    }

    public boolean getCategoryByName(String name) throws ExistCategoryException {
        Optional<Category> cat =  categories.stream()
                .filter(category -> category.getName().equalsIgnoreCase(name))
                .findAny();

        if(cat.isPresent()){
            throw new ExistCategoryException("Error, Categoria existente!!!");
        }
        return true;
    }

    public PublishSubject<List<Category>> getCategories() {
        return publishSubject;
    }
}
