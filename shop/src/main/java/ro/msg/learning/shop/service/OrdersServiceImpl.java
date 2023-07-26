package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.*;
import ro.msg.learning.shop.needed.OrderDetailId;
import ro.msg.learning.shop.needed.OrdersCreationError;
import ro.msg.learning.shop.needed.StockId;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.OrderDetailRepository;
import ro.msg.learning.shop.repository.OrdersRepository;
import ro.msg.learning.shop.repository.StockRepository;
import ro.msg.learning.shop.strategy.impl.SingleLocation;

import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    SingleLocation singleLocation;
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public void updateOrders(UUID id, Orders orders) {
        ordersRepository.deleteById(id);
        orders.setId(id);
        ordersRepository.save(orders);
    }

    @Override
    public void deleteOrders(UUID id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public Orders getOrdersById(UUID id) {
        return ordersRepository.getReferenceById(id);
    }

    @Override
    public Collection<Orders> getOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders createOrders(Orders orders, Map<UUID, Integer> productList) throws OrdersCreationError {
        return singleLocation.createOrders(orders, productList);
    }

}
