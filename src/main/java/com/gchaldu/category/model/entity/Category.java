package com.gchaldu.category.model.entity;

public class Category {
    private static Long counter=0L;
    private Long id;
    private String name;

    public Category(String name) {
        this.id=++counter;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
