package ro.msg.learning.shop.service;

import jakarta.persistence.criteria.Order;
import ro.msg.learning.shop.dto.OrdersDTO;
import ro.msg.learning.shop.entity.Location;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.entity.Orders;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface OrdersService {

    public abstract void createOrders(Orders orders);
    public abstract void updateOrders(UUID id, Orders orders);
    public abstract void deleteOrders(UUID id);
    public abstract Orders getOrdersById(UUID id);
    public abstract Collection<Orders> getOrders();

}
