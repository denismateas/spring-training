package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PRODUCT")
public class Product extends BaseEntity {

    private String name;
    private String description;
    private long price;
    private double weight;
    private String imageUrl;

    @OneToMany(mappedBy = "orderDetailId.product")
    private Set<OrderDetail> orderDetail;

    @ManyToOne
    @JoinColumn(name="productCategory", nullable=false)
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "stockId.product")
    private Set<Stock> stock;

}
