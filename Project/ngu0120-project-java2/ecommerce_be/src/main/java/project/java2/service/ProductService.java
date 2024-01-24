package project.java2.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.java2.entity.Order;
import project.java2.entity.Product;
import project.java2.exception.ResourceNotFoundException;
import project.java2.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public CompletableFuture<List<Product>> getAllProducts() {
        CompletableFuture<List<Product>> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            List<Product> products = productRepository.findAll();
            completableFuture.complete(products);
        }).start();
        return completableFuture;
    }

    public CompletableFuture<Product> getProductById(Long id) {
        CompletableFuture<Product> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            Optional<Product> product = productRepository.findById(id);
            completableFuture.complete(product.orElseThrow(() -> // lambda
                    new ResourceNotFoundException("Product", "id", id)
            ));
        }).start();
        return completableFuture;
    }
    public CompletableFuture<String> deleteProduct(Long id) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()) {
                productRepository.delete(product.get());
                completableFuture.complete("Product deleted successfully");
            } else {
                completableFuture.completeExceptionally(new ResourceNotFoundException("Product", "id", id));
            }
        }).start();
        return completableFuture;
    }
    public CompletableFuture<Product> addProduct(Product product) {
        CompletableFuture<Product> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            Product newProduct = productRepository.save(product);
            completableFuture.complete(newProduct);
        }).start();
        return completableFuture;
    }

    public CompletableFuture<Product> updateProduct(Product updatedProduct) {
        CompletableFuture<Product> completableFuture = new CompletableFuture<>();
        new Thread(() -> { // lambda
            Optional<Product> product = productRepository.findById(updatedProduct.getId());
            if (product.isPresent()) {
                product.get().setName(updatedProduct.getName());
                product.get().setPrice(updatedProduct.getPrice());
                product.get().setDescription(updatedProduct.getDescription());
                Product savedProduct = productRepository.save(product.get());
                completableFuture.complete(savedProduct);
            } else {
                completableFuture.completeExceptionally(new ResourceNotFoundException("Product", "id", updatedProduct.getId()));
            }
        }).start();
        return completableFuture;
    }


    
}
