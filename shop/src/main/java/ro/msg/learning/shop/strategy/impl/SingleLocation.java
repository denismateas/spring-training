package ro.msg.learning.shop.strategy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.entity.*;
import ro.msg.learning.shop.needed.OrderDetailId;
import ro.msg.learning.shop.needed.OrdersCreationError;
import ro.msg.learning.shop.needed.StockId;
import ro.msg.learning.shop.repository.OrdersRepository;
import ro.msg.learning.shop.service.LocationService;
import ro.msg.learning.shop.service.ProductService;
import ro.msg.learning.shop.service.StockService;

import java.util.*;
@Configuration
public class SingleLocation {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private StockService stockService;
    @Autowired
    private LocationService locationService;

    private Map<UUID, Integer> getProductsAndQuantityFromOrders(Orders orders) {
            Map<UUID, Integer> productsQuantityFromOrders = new HashMap<>();
        if(orders.getOrderDetail()!=null) {
            for (OrderDetail orderDetail : orders.getOrderDetail()) {
                UUID id = orderDetail.getOrderDetailId().getProduct().getId();
                Integer quantity = orderDetail.getQuantity();
                productsQuantityFromOrders.put(id, quantity);
            }
        }
        return productsQuantityFromOrders;
    }

    private Map<UUID, Integer> getProductsAndQuantityFromLocation(Location location) {
        Map<UUID, Integer> productsQuantityFromLocation = new HashMap<>();
        for (Stock stock : location.getStock()) {
            UUID id = stock.getStockId().getProduct().getId();
            Integer quantity = stock.getQuantity();
            productsQuantityFromLocation.put(id, quantity);
        }
        return productsQuantityFromLocation;

    }
    private Location verifyStock(Orders orders, Location location) {
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
        return location;
    }

    private Location verifyLocations(Orders orders){
        Collection<Location> locations = locationService.getLocations();
        for(Location loc : locations){
            if(verifyStock(orders, loc)!=null) {
                return loc;
            }
        }
        return null;
    }

    private void updateStock(Location location, Map<UUID, Integer> productList){
        for(Map.Entry<UUID,Integer> entry : productList.entrySet()){
            StockId stockId = new StockId(productService.getById(entry.getKey()), location);
            Stock stock = stockService.getStockById(stockId);
            stock.setQuantity(stock.getQuantity()-entry.getValue());
            stockService.updateStock(stock);
        }
    }

    public Orders createOrders(Orders orders, Map<UUID, Integer> productList) throws OrdersCreationError {
        final Location availableLocation = verifyLocations(orders);

        if(availableLocation != null) {
            Set<OrderDetail> orderDetails = new HashSet<>();
            for(Map.Entry<UUID,Integer> entry : productList.entrySet()) {
                OrderDetail orderDetail = new OrderDetail();
                Product product = new Product();
                product.setId(entry.getKey());

                OrderDetailId orderDetailId = new OrderDetailId();
                orderDetailId.setProduct(product);
                orderDetailId.setOrders(orders);

                orderDetail.setShippedFrom(availableLocation);
                orderDetail.setOrderDetailId(orderDetailId);
                orderDetail.setQuantity(entry.getValue());
                orderDetails.add(orderDetail);
            }
            orders.setOrderDetail(orderDetails);
            updateStock(availableLocation, productList);
            return ordersRepository.save(orders);
        }
        else throw new OrdersCreationError("No location found");
    }
}
