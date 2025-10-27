package com.example.orderservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String orderNumber;
  private Long productId;
  private Integer quantity;

  public Order() {
  }

  public Order(String orderNumber, Long productId, Integer quantity) {
    this.orderNumber = orderNumber;
    this.productId = productId;
    this.quantity = quantity;
  }


  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getOrderNumber() { return orderNumber; }
  public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
  public Long getProductId() { return productId; }
  public void setProductId(Long productId) { this.productId = productId; }
  public Integer getQuantity() { return quantity; }
  public void setQuantity(Integer quantity) { this.quantity = quantity; }
}