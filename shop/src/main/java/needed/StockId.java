package needed;

import entity.Location;
import entity.Product;
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
    private transient Product product;

    @ManyToOne
    @JoinColumn(name="location", nullable=false)
    private transient Location location;

}
