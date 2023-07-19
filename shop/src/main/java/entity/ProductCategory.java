package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory extends BaseEntity {

    private String name;
    private String description;

    @OneToMany(mappedBy = "product")
    private Set<Product> products;
}
