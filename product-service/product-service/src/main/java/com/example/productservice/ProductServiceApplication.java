package com.example.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}


    @Bean
    public CommandLineRunner loadData(ProductRepository productRepository) {
        return args -> {
            Product p1 = new Product("Smartphone X", 1200.0);
            Product p2 = new Product("Laptop Pro", 2500.0);
            productRepository.save(p1);
            productRepository.save(p2);
            System.out.println("2 örnek ürün veritabanına eklendi.");
        };
    }

}