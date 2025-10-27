package com.example.orderservice.controller;

import com.example.orderservice.client.ProductClient;
import com.example.orderservice.client.ProductClient.ProductDto;
import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  @Autowired
  private OrderRepository orderRepository;

  @Autowired // ProductClient'i enjekte ediyoruz.
  private ProductClient productClient;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public String placeOrder(@RequestBody Order order) {

    // 1. Ürünün varlığını kontrol et (Feign ile Product Service'i çağırır)
    ProductDto product = productClient.getProduct(order.getProductId());

    if (product == null) {
      // Ürün bulunamazsa
      return "Sipariş verilemedi: Ürün ID " + order.getProductId() + " bulunamadı!";
    }

    // 2. Sipariş oluşturma (Ürün bulundu)
    order.setOrderNumber(UUID.randomUUID().toString());
    orderRepository.save(order);

    // 3. Başarı mesajı
    return "Sipariş Başarıyla Oluşturuldu! Sipariş No: " + order.getOrderNumber()
            + ". Sipariş edilen ürün: " + product.getName() + " (Fiyat: " + product.getPrice() + ")";
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }
}