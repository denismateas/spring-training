package ro.msg.learning.shop.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ro.msg.learning.shop.dto.OrdersDTO;
import ro.msg.learning.shop.entity.Orders;
@Mapper
public interface OrdersDtoMapper {

    OrdersDtoMapper INSTANCE = Mappers.getMapper(OrdersDtoMapper.class);
    @Mapping(source = "orders.address", target = "address")
    @Mapping(source = "orders.createdAt", target = "createdAt")
    @Mapping(source = "orders.orderDetail.orderDetailId", target = "productList")
    OrdersDTO ordersToOrdersDto(Orders orders);
    @AfterMapping
    default void setProducts(@MappingTarget OrdersDTO ordersDTO, Orders orders){

    }



}
