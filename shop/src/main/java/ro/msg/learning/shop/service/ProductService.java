package ro.msg.learning.shop.service;

import ro.msg.learning.shop.entity.Product;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    public void createProduct(Product product);
    public Product updateProduct(UUID id, Product product);
    public void deleteProduct(UUID id);
    public Product getById(UUID id);
    public Collection<Product> getProducts();
}
