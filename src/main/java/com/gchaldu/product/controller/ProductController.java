package com.gchaldu.product.controller;

import com.gchaldu.category.model.entity.Category;
import com.gchaldu.product.excepciones.InputNumberExcepcion;
import com.gchaldu.product.model.entity.Product;
import com.gchaldu.product.model.repository.ProductRepository;
import io.reactivex.Observable;

import java.util.List;

public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(String name, String txtprice, Category category) throws InputNumberExcepcion {
        try {
            Double price = Double.parseDouble(txtprice);
            if(price<0){
                throw new InputNumberExcepcion("El numero tiene que ser positivo");
            }
            Product product = new Product(name, price);
            product.setCategory(category);
            repository.add(product);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Tiene que intresar un numero valido");
        }
    }

    public Observable<List<Product>> getProductObservable(){
        return repository.getListPublishSubject();
    }

}
