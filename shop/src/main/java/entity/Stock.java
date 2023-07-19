package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import needed.StockId;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="STOCK")
public class Stock {

    @EmbeddedId
    private StockId stockId;

    private int quantity;
}
