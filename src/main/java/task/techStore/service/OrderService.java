package task.techStore.service;

import task.techStore.model.dto.OrderDto;

public interface OrderService {
    void createOrder(OrderDto orderDto);
}
