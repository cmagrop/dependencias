package com.example.dependencias.repositories;

import com.example.dependencias.models.Product;

import java.util.List;

public interface ProductRepository
{
    List<Product> findAll();
    Product findById(Integer id);

}
