package com.gchaldu;

import com.gchaldu.category.controller.CategoryController;
import com.gchaldu.category.model.repository.CategoryRepository;
import com.gchaldu.category.view.CategoryView;
import com.gchaldu.product.controller.ProductController;
import com.gchaldu.product.model.repository.ProductRepository;
import com.gchaldu.product.view.ProductView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear las capas
        ProductRepository productRepository = new ProductRepository();
        ProductController productController = new ProductController(productRepository);
        ProductView productView = new ProductView();

        CategoryRepository categoryRepository = new CategoryRepository();
        CategoryController categoryController = new CategoryController(categoryRepository);
        CategoryView categoryView = new CategoryView();

        Main.main_menu(productView,categoryView,productController,categoryController);

    }

    public static void main_menu(ProductView productView,
                                 CategoryView categoryView,
                                 ProductController productController,
                                 CategoryController categoryController){
        boolean salir=true;
        while (salir) {
            display_main();
            Scanner scanner = new Scanner(System.in);
            String op = scanner.nextLine();
            switch (op){
                case "1": {
                    // Iniciar la vista
                    try {
                        productView.start(productController, categoryController);
                    } finally {
                        productView.stop();
                    }
                    break;
                }
                case "2":{
                    categoryView.addCategory(categoryController);
                    break;
                }
                case "3":{
                    salir=false;
                    break;
                }

            }
        }
    }

    public static void display_main(){
        System.out.println("1 - Products");
        System.out.println("2 - Categories");
        System.out.println("3 - Salir");
    }
}
