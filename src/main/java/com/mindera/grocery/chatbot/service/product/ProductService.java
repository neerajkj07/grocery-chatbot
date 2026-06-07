package com.mindera.grocery.chatbot.service.product;

import com.mindera.grocery.chatbot.entity.Product;
import com.mindera.grocery.chatbot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Get products by category
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    // Search products by name
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    // Get products in stock
    public List<Product> getProductsInStock() {
        return productRepository.findByStockGreaterThan(0);
    }

    // Save a new product or update existing
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // Update stock
    public Product updateStock(Long id, Integer newStock) {
        Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setStock(newStock);
            return productRepository.save(product);
        }
        throw new RuntimeException("Product not found with id: " + id);
    }
}
