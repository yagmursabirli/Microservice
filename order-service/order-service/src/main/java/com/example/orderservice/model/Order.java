package com.example.orderservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_orders") // 'Order' SQL'de anahtar kelime olabileceği için tablo adını değiştirdik.
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String orderNumber;
  private Long productId; // Sipariş edilen ürünün ID'si
  private Integer quantity; // Sipariş miktarı

  // --- Constructor'lar ---
  public Order() {
  }

  public Order(String orderNumber, Long productId, Integer quantity) {
    this.orderNumber = orderNumber;
    this.productId = productId;
    this.quantity = quantity;
  }

  // --- Getter ve Setter Metotları ---

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getOrderNumber() { return orderNumber; }
  public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
  public Long getProductId() { return productId; }
  public void setProductId(Long productId) { this.productId = productId; }
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }
}