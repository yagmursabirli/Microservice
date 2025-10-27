package com.example.productservice.repository;

import com.example.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<[Entity Sınıfı], [Primary Key Tipi]>
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  // Spring Data JPA sayesinde bu arayüz boş olsa bile
  // save(), findAll(), findById() gibi metotları kullanabilirsiniz.
}