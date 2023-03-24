package task.techStore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.techStore.model.dto.OrderDto;
import task.techStore.model.dto.OrderMapper;
import task.techStore.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        orderDto.setCreated(LocalDateTime.now());
        orderRepository.save(OrderMapper.toOrder(orderDto));
        Optional<>orderRepository.findById()
        return orderRepository;
    }
}
