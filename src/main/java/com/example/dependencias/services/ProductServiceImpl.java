package com.example.dependencias.services;

import com.example.dependencias.models.Product;
import com.example.dependencias.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    //atributos
    @Value("${config.price.iva}")
    private Double iva;//asigname el @Value


    private ProductRepository repository;

    //está llamando al @Bean que fue declarado en AppConfig.java
    public ProductServiceImpl(@Qualifier("productJson")
                              ProductRepository repository)
    {
        this.repository = repository;

    }


    @Override
    public List<Product> findAll()
    {
        return repository.findAll().stream().map(
                product ->
        {
            Double priceIva = product.getPrice()*iva;
            Product newProduct = product.clone();
            newProduct.setPrice((int) priceIva.doubleValue());
            return newProduct;

        }

        ).collect(Collectors.toList());
    }

    @Override
    public Product findById(Integer id) {
        return repository.findById(id);
    }
}
