package project.java2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.java2.entity.Order;
import project.java2.exception.ResourceNotFoundException;
import project.java2.repository.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderService {

	
	
    @Autowired
    private OrderRepository orderRepository;

    public CompletableFuture<List<Order>> getAllOrders() {
        return CompletableFuture.supplyAsync(() -> orderRepository.findAll());
    }


    public CompletableFuture<Order> createOrder(Order order) { // CompletableFuture
        CompletableFuture<Order> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            Order savedOrder = orderRepository.save(order);
            completableFuture.complete(savedOrder);
        }).start();
        return completableFuture;
    }
    
    
    public CompletableFuture<Void> deleteOrder(Long orderId) {
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        new Thread(() -> { //lamda
            Optional<Order> optionalOrder = orderRepository.findById(orderId);
            if (optionalOrder.isPresent()) {
                orderRepository.delete(optionalOrder.get());
                completableFuture.complete(null);
            } else {
                completableFuture.completeExceptionally(new ResourceNotFoundException("Order", "id", orderId));
            }
        }).start();
        return completableFuture;
    }


    
    
    
    
    


}