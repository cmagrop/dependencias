package com.example.dependencias;

import com.example.dependencias.repositories.ProductRepository;
import com.example.dependencias.repositories.ProductRepositoryImplJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties")

public class AppConfig {

    @Value("classpath:json/product.json")
    private Resource resource;

    @Bean("productJson")
    ProductRepository productRepositoryJson()
    {
        return new ProductRepositoryImplJson();
    }

}
