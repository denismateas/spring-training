package ro.msg.learning.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.entity.ProductCategory;
import ro.msg.learning.shop.mapper.ProductDtoMapper;
import ro.msg.learning.shop.service.ProductService;

import java.util.UUID;

public class ProductServiceController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductDtoMapper productDtoMapper;

    @RequestMapping(value="/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }
    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Object>
    updateProduct(@PathVariable("id") UUID id, @RequestBody Product product) {

        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") UUID id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
    }
    @PostMapping(value = "/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product, ProductCategory productCategory) {
        productService.createProduct(product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
}
