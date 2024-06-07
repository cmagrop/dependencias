package com.example.dependencias.models;

public class Product implements Cloneable{
    private Integer id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(Integer id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public Product clone() {
        try {
            Product clone = (Product) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return new Product(this.getId(),this.getName(),this.getPrice());
        }
    }
}
