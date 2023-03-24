package task.techStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.techStore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
