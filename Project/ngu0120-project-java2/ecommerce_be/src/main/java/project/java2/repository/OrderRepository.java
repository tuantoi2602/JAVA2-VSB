package project.java2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.java2.entity.Order;

// JPA
public interface OrderRepository extends JpaRepository<Order, Long> {
}
