package task.techStore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import task.techStore.model.dto.ItemDto;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    /**
     * Save a item.
     *
     * @param itemDTO the entity to save.
     * @return the persisted entity.
     */
    ItemDto save(ItemDto itemDTO);

    /**
     * Updates a item.
     *
     * @param itemDTO the entity to update.
     * @return the persisted entity.
     */
    ItemDto update(ItemDto itemDTO);

    /**
     * Get all the items.
     *
     * @return the list of entities.
     */
    List<ItemDto> findAll();

    /**
     * Get the "id" item.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    ItemDto findOne(Long id);

    /**
     * Delete the "id" item.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

