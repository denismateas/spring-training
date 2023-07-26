package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.needed.Address;
import ro.msg.learning.shop.needed.OrderDetailId;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ORDERS")
public class Orders extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="customer")
    private Customer customer;
    private LocalDateTime createdAt;
    private Address address;

    @OneToMany(mappedBy = "orderDetailId.orders", cascade = CascadeType.PERSIST)
    private Set<OrderDetail> orderDetail;

    public void addOrderDetail(final OrderDetail orderDetails){
        orderDetail.add(orderDetails);
        orderDetails.getOrderDetailId().setOrders(this);
    }



}
