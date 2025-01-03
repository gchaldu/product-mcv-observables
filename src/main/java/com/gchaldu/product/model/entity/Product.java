package com.gchaldu.product.model.entity;

import com.gchaldu.category.model.entity.Category;

public class Product {

    private Long id;
    private static Long counter=0L;
    private String name;
    private Double price;
    private Category category;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
        this.id=++counter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category.getName() +
                '}';
    }
}
