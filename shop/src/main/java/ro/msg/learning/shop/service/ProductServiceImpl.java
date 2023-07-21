package ro.msg.learning.shop.service;

import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.Product;

import java.util.*;
@Service
public class ProductServiceImpl implements ProductService {
    private static final Map<UUID, Product> productRepository = new HashMap<>();

    @Override
    public void createProduct(Product product) {
        productRepository.put(product.getId(), product);
    }

    @Override
    public void updateProduct(UUID id, Product product) {
        productRepository.remove(id);
        product.setId(id);
        productRepository.put(id, product);

    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.remove(id);
    }

    @Override
    public Product getById(UUID id) {
        return productRepository.get(id);
    }
    @Override
    public Collection<Product> getProducts() {
        return productRepository.values();
    }
}
