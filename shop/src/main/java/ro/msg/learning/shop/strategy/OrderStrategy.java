package ro.msg.learning.shop.strategy;

import ro.msg.learning.shop.entity.Orders;

import java.util.Map;
import java.util.UUID;

public interface OrderStrategy {
    public Orders createOrders(Orders orders, Map<UUID, Integer> productList);

}
