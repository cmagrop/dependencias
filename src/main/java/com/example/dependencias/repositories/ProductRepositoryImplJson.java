package com.example.dependencias.repositories;

import com.example.dependencias.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryImplJson implements  ProductRepository
{
    private List<Product> list;



    public ProductRepositoryImplJson()
    {
        Resource resource = new ClassPathResource("json/product.json");
        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {

        //nos permitirá mapear al Json para que esté disponible
        ObjectMapper objectMapper = new ObjectMapper();
        try{

            list =
                    Arrays.asList(objectMapper.readValue(
                            resource.getInputStream(),Product.class));
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    @Override
    public Product findById(Integer id) {
        return list.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public List<Product> findAll() {
        return list;
    }
}
