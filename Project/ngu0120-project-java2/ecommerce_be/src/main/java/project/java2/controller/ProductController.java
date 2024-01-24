package project.java2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import project.java2.entity.Product;
import project.java2.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    private static final Logger log = LogManager.getLogger(ProductController.class); // Log4j2
    @Autowired
    private ProductService productService;

    @GetMapping
    public CompletableFuture<List<Product>> getAllProducts() {
        log.info("Fetching all product"); // Log4j2
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Product> getProductById(@PathVariable Long id) {
        log.info("Fetching product with id {}", id); // Log4j2
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public CompletableFuture<String> deleteProduct(@PathVariable Long id) {
        log.info("Deleting product with id {}", id);
        return productService.deleteProduct(id)
                .exceptionally(ex -> {
                    log.error("Error deleting product with id {}", id, ex);
                    return "Error deleting product with id " + id + ": " + ex.getMessage();
                });
    }
    @PostMapping
    public CompletableFuture<Product> addProduct(@RequestBody Product product) {
    	log.info("Adding new product with name {} and productId {}", product.getName(), product.getId());
        return productService.addProduct(product);
    }

    
    @PutMapping("/{id}")
    public CompletableFuture<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        log.info("Updating product with id {}", id);
        updatedProduct.setId(id);
        return productService.updateProduct(updatedProduct)
                .exceptionally(ex -> {
                    log.error("Error updating product with id {}", id, ex);
                    return null;
                });
    }


}
