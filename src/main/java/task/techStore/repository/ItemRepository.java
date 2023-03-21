package task.techStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.techStore.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
