package task.techStore.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import task.techStore.model.dto.OrderDto;
import task.techStore.service.OrderService;

import javax.validation.Valid;

@Slf4j
@Valid
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/new")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        log.info("Creating new order");
        return orderService.createOrder(orderDto);
    }
}
