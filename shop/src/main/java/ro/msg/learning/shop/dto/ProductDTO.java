package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private UUID id;
    private UUID categoryId;
    private String name;
    private String description;
    private long price;
    private double weight;
    private String imageUrl;
    private String categoryName;
    private String categoryDescription;

}
