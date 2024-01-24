package project.java2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import project.java2.entity.Order;
import project.java2.entity.Product;
import project.java2.exception.ResourceNotFoundException;
import project.java2.repository.OrderRepository;
import project.java2.repository.ProductRepository;
import project.java2.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    private static final Logger log = LogManager.getLogger(OrderController.class); // Log4j2
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public CompletableFuture<List<Order>> getAllOrders() { // CompletableFuture
        log.info("Fetching all order"); // Log4j2
        return orderService.getAllOrders();
    }
    @PostMapping
    public CompletableFuture<Order> createOrder(@RequestBody Order order) {
        log.info("Creating order with ID " + order.getId());
        return orderService.createOrder(order);
    }


    @DeleteMapping("/{orderId}")
    public CompletableFuture<Void> deleteOrder(@PathVariable Long orderId) { // CompletableFuture
        log.info("Deleting order with id {}", orderId); // Log4j2
        return orderService.deleteOrder(orderId);
    }





}