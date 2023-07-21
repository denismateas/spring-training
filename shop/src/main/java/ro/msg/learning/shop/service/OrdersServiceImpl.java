package ro.msg.learning.shop.service;

import ro.msg.learning.shop.entity.Location;
import ro.msg.learning.shop.entity.Orders;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OrdersServiceImpl implements OrdersService {

    private static final Map<UUID, Orders> ordersRepository = new HashMap<>();

    @Override
    public void createOrders(Orders orders) {
        ordersRepository.put(orders.getId(), orders);
    }

    @Override
    public void updateOrders(UUID id, Orders orders) {
        ordersRepository.remove(id);
        orders.setId(id);
        ordersRepository.put(id, orders);
    }

    @Override
    public void deleteOrders(UUID id) {
        ordersRepository.remove(id);
    }

    @Override
    public Orders getOrdersById(UUID id) {
        return ordersRepository.get(id);
    }

    @Override
    public Collection<Orders> getOrders() {
        return ordersRepository.values();
    }

    Location locations;
    @Override
    public void findLocation(Orders orders){
        //
    }
}
