package com.example.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// FeignClient notu ile hangi servisi hangi URL'de çağıracağımızı tanımlarız.
// Eureka kullanmadığımız için URL'i statik olarak belirtiyoruz.
@FeignClient(name = "product-service", url = "http://localhost:8081")
public interface ProductClient {

  // Product Service'deki GET /api/products/{id} endpoint'ini çağırır
  @GetMapping("/api/products/{id}")
  ProductDto getProduct(@PathVariable("id") Long id);

  // Çağrılan servisten dönecek veriyi tutmak için iç içe (nested) bir DTO sınıfı (Sadece ihtiyacımız olan alanlar var).
  class ProductDto {
    private Long id;
    private String name;
    private double price;

    // Mutlaka Parametresiz Constructor
    public ProductDto() {}

    // Getter ve Setter'lar
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
  }
}