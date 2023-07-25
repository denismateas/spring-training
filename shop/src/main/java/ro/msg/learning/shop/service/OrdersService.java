package ro.msg.learning.shop.service;


import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.needed.OrdersCreationError;

import java.util.Collection;
import java.util.UUID;

public interface OrdersService {

    public void createOrders(Orders orders) throws OrdersCreationError;
    public void updateOrders(UUID id, Orders orders);
    public void deleteOrders(UUID id);
    public Orders getOrdersById(UUID id);
    public Collection<Orders> getOrders();

}
