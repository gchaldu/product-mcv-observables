package com.gchaldu;

import com.gchaldu.category.controller.CategoryController;
import com.gchaldu.category.model.repository.CategoryRepository;
import com.gchaldu.category.view.CategoryView;
import com.gchaldu.product.controller.ProductController;
import com.gchaldu.product.model.repository.ProductRepository;
import com.gchaldu.product.view.ProductView;

public class Main {
    public static void main(String[] args) {
        // Crear las capas
        ProductRepository productRepository = new ProductRepository();
        ProductController productController = new ProductController(productRepository);
        ProductView productView = new ProductView();

        CategoryRepository categoryRepository = new CategoryRepository();
        CategoryController categoryController = new CategoryController(categoryRepository);
        CategoryView categoryView = new CategoryView();


        // Iniciar la vista
        try {
            productView.start(productController, categoryController);
        } finally {
            productView.stop();
        }
    }
}
