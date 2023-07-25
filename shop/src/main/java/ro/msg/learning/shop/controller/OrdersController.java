package ro.msg.learning.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.OrdersDTO;
import ro.msg.learning.shop.entity.Orders;
import ro.msg.learning.shop.mapper.OrdersDtoMapper;
import ro.msg.learning.shop.needed.OrdersCreationError;
import ro.msg.learning.shop.service.OrdersService;

import java.util.ArrayList;
import java.util.Collection;

@RequestMapping(value = "/orders")
@RestController
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping
    public ResponseEntity<Object> createOrders(OrdersDTO ordersDTO) throws OrdersCreationError {
        ordersService.createOrders(OrdersDtoMapper.INSTANCE.ordersDtoToOrders(ordersDTO));
        return new ResponseEntity<>("Orders created successfully", HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Object> getOrders(){
        Collection<Orders> orders = ordersService.getOrders();
        Collection<OrdersDTO> ordersDTO = new ArrayList<>();
        for(Orders orderss : orders)
            ordersDTO.add(OrdersDtoMapper.INSTANCE.ordersToOrdersDto(orderss));
        return new ResponseEntity<>(ordersDTO, HttpStatus.OK);
    }

}
