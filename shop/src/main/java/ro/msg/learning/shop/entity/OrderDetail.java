package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.*;
import ro.msg.learning.shop.needed.OrderDetailId;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ORDER_DETAIL")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId orderDetailId;

    private int quantity;

    @ManyToOne()
    @JoinColumn(name="location")
    private Location shippedFrom;


}
