package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import needed.OrderDetailId;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ORDER_DETAIL")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    private int quantity;


}
