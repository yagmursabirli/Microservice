package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Bu sınıfın HTTP isteklerini işleyecek bir REST API Controller olduğunu belirtir.
@RequestMapping("/api/products") // Tüm metotlar /api/products yolu altında çalışır.
public class ProductController {

  @Autowired // Spring'in ProductRepository arayüzünün bir örneğini otomatik olarak enjekte etmesini sağlar.
  private ProductRepository productRepository;

  // POST /api/products - Yeni bir ürün oluşturur
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED) // Başarılı cevap durumunu 201 Created olarak ayarlar.
  public Product createProduct(@RequestBody Product product) {
    return productRepository.save(product);
  }

  // GET /api/products - Tüm ürünleri listeler
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }
}