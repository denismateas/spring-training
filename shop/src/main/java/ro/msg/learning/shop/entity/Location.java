package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.needed.Address;

import java.util.Set;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LOCATION")
public class Location extends BaseEntity {

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "stockId.location", cascade=CascadeType.ALL)
    private Set<Stock> stock;

    @OneToMany(mappedBy = "shippedFrom", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetail;

}
