package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.needed.Address;

import java.io.Serializable;
import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LOCATION")
public class Location extends BaseEntity {

    private String name;

    private Address address;

    @OneToMany(mappedBy = "stockId.location")
    private Set<Stock> stock;

    @OneToMany(mappedBy = "shippedFrom")
    private Set<OrderDetail> orderDetail;

}
