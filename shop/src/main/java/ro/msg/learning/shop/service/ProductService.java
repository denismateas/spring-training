package ro.msg.learning.shop.service;

import ro.msg.learning.shop.entity.Product;

import java.util.Collection;
import java.util.UUID;

public interface ProductService {

    public abstract void createProduct(Product product);
    public abstract void updateProduct(UUID id, Product product);
    public abstract void deleteProduct(UUID id);
    public abstract Product getById(UUID id);
    public abstract Collection<Product> getProducts();
}
