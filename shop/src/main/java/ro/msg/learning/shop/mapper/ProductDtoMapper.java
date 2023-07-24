package ro.msg.learning.shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.entity.Product;

@Mapper
public interface ProductDtoMapper {
    ProductDtoMapper INSTANCE = Mappers.getMapper(ProductDtoMapper.class);

    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.id", target = "id")
    @Mapping(source = "product.description", target = "description")
    @Mapping(source = "product.price", target = "price")
    @Mapping(source = "product.weight", target = "weight")
    @Mapping(source = "product.imageUrl", target = "imageUrl")
    @Mapping(source = "productCategory.name", target = "categoryName")
    @Mapping(source = "productCategory.description", target = "categoryDescription")
    @Mapping(source = "productCategory.id", target = "categoryId")
    ProductDTO productToProductDto(Product product);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "weight", target = "weight")
    @Mapping(source = "imageUrl", target = "imageUrl")
    @Mapping(source = "categoryName", target = "productCategory.name")
    @Mapping(source = "categoryDescription", target = "productCategory.description")
    @Mapping(source = "categoryId", target = "productCategory.id")
    Product productDtoToProduct(ProductDTO productDto);



}
