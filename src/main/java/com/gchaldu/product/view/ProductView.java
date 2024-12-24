package com.gchaldu.product.view;

import com.gchaldu.product.controller.ProductController;
import com.gchaldu.product.excepciones.InputNumberExcepcion;
import com.gchaldu.product.model.entity.Product;
import io.reactivex.disposables.Disposable;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

public class ProductView {

    private Disposable subscription;
    private final Scanner scanner = new Scanner(System.in);

    public void start(ProductController controller) {
        // La Vista se suscribe al observable del controlador
        subscription = controller.getProductObservable().subscribe(
                products -> displayProducts(products),
                error -> displayError("Error al obtener productos: " + error.getMessage())
        );

        // Interactuar con el usuario
        boolean exit = false;
        while (!exit) {
            displayMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    add(controller);
                    break;
                case "2":
                    exit = true;
                    break;
                default:
                    displayError("Opción inválida. Intente de nuevo.");
            }
        }

        stop();
    }

    public void add(ProductController controller){
        try{
            System.out.println("Ingrese el nombre del producto");
            String name = scanner.nextLine();

            System.out.println("Ingrese el precio del producto");
            String txtPrice = scanner.nextLine();

            controller.addProduct(name,txtPrice);

        }catch (IllegalArgumentException e){
            displayError(e.getMessage());
        } catch (InputNumberExcepcion e) {
            System.out.println(e.getMessage());
        }

    }

    private void displayMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar producto");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void displayProducts(List<Product> products) {
        System.out.println("\nListado de productos:");
        if (products.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            products.forEach(System.out::println);
        }
    }

    private void displayError(String message) {
        System.out.println("Error: " + message);
    }

    public void stop() {
        if (subscription != null && !subscription.isDisposed()) {
            subscription.dispose();
        }
    }

}
