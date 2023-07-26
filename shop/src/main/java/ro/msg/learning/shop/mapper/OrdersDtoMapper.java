package ro.msg.learning.shop.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ro.msg.learning.shop.dto.OrdersDTO;
import ro.msg.learning.shop.entity.Orders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mapper
public interface OrdersDtoMapper {

    OrdersDtoMapper INSTANCE = Mappers.getMapper(OrdersDtoMapper.class);

    @Mapping(source = "orders.address", target = "address")
    @Mapping(source = "orders.createdAt", target = "createdAt")
    OrdersDTO ordersToOrdersDto(Orders orders);

    @AfterMapping
    default void idAfterMapping(Orders orders, @MappingTarget OrdersDTO orderDTO) {

        final Map<UUID, Integer> productList = new HashMap<>();

        orders.getOrderDetail().forEach(orderDetail -> productList.put(
                orderDetail.getOrderDetailId().getProduct().getId(),
                orderDetail.getQuantity()
        ));
        orderDTO.setProductList(productList);
    }

    Orders ordersDtoToOrders(OrdersDTO ordersDTO);

}
