package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.needed.Address;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {

    private LocalDate createdAt;
    private Address address;

    private Map<UUID, Integer> productList;



}
