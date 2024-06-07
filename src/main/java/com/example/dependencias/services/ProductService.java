package com.example.dependencias.services;

import com.example.dependencias.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Integer id);

}
