package com.gchaldu.category.view;

import com.gchaldu.category.controller.CategoryController;
import com.gchaldu.category.model.entity.Category;
import io.reactivex.disposables.Disposable;

import java.util.List;
import java.util.Scanner;

public class CategoryView {

    private final Scanner scanner = new Scanner(System.in);
    Disposable subscription;

    public void start(CategoryController controller){

        subscription = controller.getRepository().getCategories().subscribe(
                categories -> displayCategories(categories),
                throwable -> System.out.println("Error al listar categorias!!!")
        );


        boolean out = true;
        while (out){
            displayMenu();
            String op = scanner.nextLine();
            switch (op){
                case "1":{
                    addCategory(controller);
                    break;
                }
                case "2":{
                    out=false;
                    break;
                }
            }
        }
    }

    public void addCategory(CategoryController controller){
        System.out.println("ingrese el nombre de la categoria");
        String name = scanner.nextLine();
        controller.add(name);
    }

    public void displayMenu(){
        System.out.println("1 - Ingresar category");
        System.out.println("2 - Salir");
    }

    public void displayCategories(List<Category> categories){
        categories.forEach(category -> {
            System.out.println("Id: " + category.getId());
            System.out.println("Name: " + category.getName());
        });
    }

    public void stop(){
        if(subscription!=null && !subscription.isDisposed()){
            subscription.dispose();
        }
    }
}
