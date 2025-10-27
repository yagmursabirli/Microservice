package com.example.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Bu sınıfın bir JPA veritabanı varlığı (tablosu) olduğunu belirtir.
public class Product {

  @Id // Bu alanın birincil anahtar (Primary Key) olduğunu belirtir.
  @GeneratedValue(strategy = GenerationType.IDENTITY) // ID'nin otomatik oluşturulmasını sağlar.
  private Long id;
  private String name;
  private double price;

  // --- Constructor'lar ---

  // JPA için gerekli olan parametresiz constructor
  public Product() {
  }

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  // --- Getter ve Setter Metotları ---
  // (Lombok kullanmadıysanız, bu metotları elle eklemeniz gerekir.)

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}