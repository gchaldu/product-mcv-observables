package com.gchaldu.product;

import com.gchaldu.product.controller.ProductController;
import com.gchaldu.product.model.repository.ProductRepository;
import com.gchaldu.product.view.ProductView;

public class Main {
    public static void main(String[] args) {
        // Crear las capas
        ProductRepository repository = new ProductRepository();
        ProductController controller = new ProductController(repository);
        ProductView view = new ProductView();

        // Iniciar la vista
        try {
            view.start(controller);
        } finally {
            // Asegurarse de liberar recursos
            view.stop();
        }
    }
}
