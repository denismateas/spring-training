package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Product updateProduct(@PathVariable UUID id, @RequestBody Product newProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setProductCategory(newProduct.getProductCategory());
                    product.setPrice(newProduct.getPrice());
                    product.setWeight(newProduct.getWeight());
                    product.setImageUrl(newProduct.getImageUrl());
                    product.setDescription(newProduct.getDescription());
                    product.setStock(newProduct.getStock());
                    product.setOrderDetail(newProduct.getOrderDetail());
                    return productRepository.save(newProduct);
                })
                .orElseGet(()->{
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
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
