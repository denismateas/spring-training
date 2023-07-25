package ro.msg.learning.shop.mapper;

import org.aspectj.lang.annotation.After;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ro.msg.learning.shop.dto.OrdersDTO;
import ro.msg.learning.shop.entity.OrderDetail;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.entity.Product;

@Mapper
public interface OrdersDtoMapper {

    OrdersDtoMapper INSTANCE = Mappers.getMapper(OrdersDtoMapper.class);
    @Mapping(source = "orders.address", target = "address")
    @Mapping(source = "orders.createdAt", target = "createdAt")
    OrdersDTO ordersToOrdersDto(Orders orders);
    @AfterMapping
    default void setOrders(@MappingTarget OrdersDTO ordersDTO, Orders orders, Product product) {
        ordersDTO.getProductList().put(
                product.getId(),
                orders.getOrderDetail().stream().findAny().get().getQuantity()
                );
    }

    Orders ordersDtoToOrders(OrdersDTO ordersDTO);
    @AfterMapping
    default void mapAfterMapping(OrdersDTO ordersDTO, @MappingTarget Orders orders)
    {
        if(orders.getOrderDetail() !=null)
            orders.getOrderDetail().add((OrderDetail)ordersDTO.getProductList());
    }


}
