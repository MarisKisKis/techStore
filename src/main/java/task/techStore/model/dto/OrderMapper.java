package task.techStore.model.dto;

import task.techStore.model.Order;

import java.time.LocalDateTime;

public class OrderMapper {

    public static Order toOrder (OrderDto orderDto) {
        return Order.builder()
                .totalPrice(orderDto.getTotalPrice())
                .items(orderDto.getItems())
                .created(orderDto.getCreated())
                .build();
    }

    public static OrderDto toOrderDto (Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .totalPrice(order.getTotalPrice())
                .items(order.getItems())
                .created(order.getCreated())
                .build();
    }
}
