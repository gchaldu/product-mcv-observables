package com.gchaldu.product.model.repository;

import com.gchaldu.product.model.entity.Product;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();
    private final PublishSubject<List<Product>> listPublishSubject = PublishSubject.create();

    public void add(Product product){
        this.productList.add(product);
        listPublishSubject.onNext(productList);
    }

    public Observable<List<Product>> getListPublishSubject() {
        return listPublishSubject;
    }
}
