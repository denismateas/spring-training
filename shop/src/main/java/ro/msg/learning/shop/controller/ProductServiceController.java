package ro.msg.learning.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entity.Product;
import ro.msg.learning.shop.entity.ProductCategory;
import ro.msg.learning.shop.mapper.ProductDtoMapper;
import ro.msg.learning.shop.service.ProductService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
@RequestMapping(value = "/product")
@RestController
public class ProductServiceController {
    private final ProductService productService;

    public ProductServiceController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(UUID id){
        return new ResponseEntity<>(ProductDtoMapper.INSTANCE.productToProductDto(productService.getById(id)), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Object> getProducts(){
        Collection<Product> products = productService.getProducts();
        Collection<ProductDTO> productDTO = new ArrayList<>();
        for(Product product : products)
            productDTO.add(ProductDtoMapper.INSTANCE.productToProductDto(product));
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }
    @PutMapping(value = "/put")
    public ResponseEntity<Object> updateProduct(@RequestParam("id") @PathVariable("id") UUID id, @RequestBody ProductDTO productDto) {
        productService.updateProduct(id, ProductDtoMapper.INSTANCE.productDtoToProduct(productDto));
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> deleteProduct(@RequestParam("id") @PathVariable("id") UUID id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
    @PostMapping(value = "/post")
    public ResponseEntity<Object> createProduct(@RequestBody ProductDTO productDto, ProductCategory productCategory) {
        productService.createProduct(ProductDtoMapper.INSTANCE.productDtoToProduct(productDto));
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }
}
