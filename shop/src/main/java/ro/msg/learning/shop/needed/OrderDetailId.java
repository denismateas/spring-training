package ro.msg.learning.shop.needed;

import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
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
