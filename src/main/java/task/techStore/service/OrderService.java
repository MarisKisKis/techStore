package task.techStore.service;

import task.techStore.model.dto.OrderDto;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
}
