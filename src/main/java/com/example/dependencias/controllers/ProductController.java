package com.example.dependencias.controllers;

import com.example.dependencias.models.Product;
import com.example.dependencias.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> list()
    {
        return service.findAll();

    }

    @GetMapping("/{id}")
    public Product showProduct(@PathVariable Integer id)
    {
        return service.findById(id);


    }

}
