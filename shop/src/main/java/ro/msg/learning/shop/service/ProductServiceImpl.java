package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.repository.ProductRepository;

import java.util.*;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(UUID id, Product product) {
        productRepository.deleteById(id);
        product.setId(id);
        productRepository.save(product);

    }

    @Override
    public void deleteProduct(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(UUID id) {
        return productRepository.getReferenceById(id);
    }
    @Override
    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }
}
