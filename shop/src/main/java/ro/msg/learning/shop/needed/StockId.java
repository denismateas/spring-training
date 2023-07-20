package ro.msg.learning.shop.needed;

import ro.msg.learning.shop.entity.Location;
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
public class StockId implements Serializable {

    @ManyToOne
    @JoinColumn(name="product", nullable=false)
    private Product product;

    @ManyToOne
    @JoinColumn(name="location", nullable=false)
    private Location location;

}
