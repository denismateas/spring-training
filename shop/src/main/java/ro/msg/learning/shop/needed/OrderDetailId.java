package ro.msg.learning.shop.needed;

import lombok.*;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailId implements Serializable {

    @ManyToOne
    @JoinColumn(name="orders", nullable=false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="product", nullable=false)
    private Product product;

}
