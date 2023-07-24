package ro.msg.learning.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entity.*;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.OrdersRepository;

import java.util.*;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    LocationRepository locationRepository;

    @Override
    public void createOrders(Orders orders) {
        ordersRepository.save(orders);
    }

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

    public Map<UUID, Integer> getProductsAndQuantityFromOrders(Orders orders) {
        Map<UUID, Integer> productsQuantityFromOrders = new HashMap<>();
        for (OrderDetail orderDetail : orders.getOrderDetail()) {
            Map.of(orderDetail.getOrderDetailId().getProduct().getId(), orderDetail.getQuantity());
        }
        return productsQuantityFromOrders;
    }

    public Map<UUID, Integer> getProductsAndQuantityFromLocation(Location location) {
        Map<UUID, Integer> productsQuantityFromLocation = new HashMap<>();
        for (Stock stock : location.getStock()) {
            Map.of(stock.getStockId().getProduct().getId(), stock.getQuantity());
        }
        return productsQuantityFromLocation;

    }
    public Location verifyStock(Orders orders, Location location) {
        Map<UUID, Integer> productsAndQuantityFromOrders = getProductsAndQuantityFromOrders(orders);
        Map<UUID, Integer> productQuantityFromLocation = getProductsAndQuantityFromLocation(location);

        for(UUID idProdusOrders : productsAndQuantityFromOrders.keySet())
            if(!(productQuantityFromLocation.containsKey(idProdusOrders)))
                return null;

        for(UUID idProdusOrders : productsAndQuantityFromOrders.keySet())
            for(UUID idProdusLocation : productQuantityFromLocation.keySet()){
                if(idProdusOrders == idProdusLocation &&
                        (productsAndQuantityFromOrders.get(idProdusOrders) >
                                (productQuantityFromLocation.get(idProdusLocation))))
                    return null;
                }

        for(UUID idProdusOrders : productsAndQuantityFromOrders.keySet())
            for(UUID idProdusLocation : productQuantityFromLocation.keySet())
                if(idProdusOrders == idProdusLocation)
                    productQuantityFromLocation.put(idProdusLocation, productQuantityFromLocation.get(idProdusLocation)
                    -productsAndQuantityFromOrders.get(idProdusLocation));
        return location;
    }

    public Location verifyLocations(Orders orders, Location location){
        List<Location> locations = locationRepository.findAll();
        for(Location loc : locations){
            if(verifyStock(orders, loc)!=null) {
               // for(Stock stock : loc.getStock())
                    return location;
            }
        }
        return null;
    }

}
