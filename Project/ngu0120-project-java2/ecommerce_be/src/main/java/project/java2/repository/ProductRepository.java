package project.java2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.java2.entity.Product;

// JPA
public interface ProductRepository extends JpaRepository<Product, Long> {
}