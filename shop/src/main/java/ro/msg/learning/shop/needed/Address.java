package ro.msg.learning.shop.needed;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Address {

    private String country;
    private String city;
    private String county;
    private String street;



}
