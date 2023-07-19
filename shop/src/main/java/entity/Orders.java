package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import needed.Address;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Table(name="ORDERS")
public class Orders extends BaseEntity {

    private Customer customer;
    private LocalDateTime createdAt;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetail;



}
