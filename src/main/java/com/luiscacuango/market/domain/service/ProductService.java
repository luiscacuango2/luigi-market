package com.luiscacuango.market.domain.service;

import com.luiscacuango.market.domain.Product;
import com.luiscacuango.market.domain.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    @Transactional
    public Product save(Product product) {
        // Si es un producto nuevo, el ID debe ser null para que JPA haga un INSERT
        // Si recibes un 0 del frontend/postman, cámbialo a null
        if (product.getProductId() != null && product.getProductId() == 0) {
            product.setProductId(null);
        }
        return productRepository.save(product);
    }

    @Transactional
    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
