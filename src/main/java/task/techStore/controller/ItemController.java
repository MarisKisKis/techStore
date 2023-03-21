package task.techStore.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.techStore.exception.BadRequestAlertException;
import task.techStore.model.dto.ItemDto;
import task.techStore.repository.ItemRepository;
import task.techStore.service.ItemService;


import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@RestController
@Slf4j
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemService itemService, ItemRepository itemRepository) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    /**
     * {@code POST  /new} : Create a new item.
     *
     * @param itemDTO the itemDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new itemDTO, or with status {@code 400 (Bad Request)} if the item has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/new")
    public ItemDto createItem(@Valid @RequestBody ItemDto itemDTO) throws URISyntaxException {
        log.info("REST request to save Item");
        return itemService.save(itemDTO);
    }

    /**
     * {@code PUT  /update/:id} : Updates an existing item.
     *
     * @param id the id of the itemDTO to save.
     * @param itemDTO the itemDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated itemDTO,
     * or with status {@code 400 (Bad Request)} if the itemDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the itemDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/update/{id}")
    public ItemDto updateItem(
            @PathVariable(value = "id", required = false) final Long id,
            @Valid @RequestBody ItemDto itemDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Item : {}, {}", id, itemDTO);
        if (!Objects.equals(id, itemDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID");
        }
        if (!itemRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        return itemService.update(itemDTO);
    }

    /**
     * {@code GET  } : get all the items.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of items in body.
     */
    @GetMapping
    public List<ItemDto> getAllItems() {
        log.info("REST request to get a page of Items");
        return itemService.findAll();
    }

    /**
     * {@code GET  /:id} : get the "id" item.
     *
     * @param itemId the id of the itemDTO to retrieve.
     */
    @GetMapping("/{itemId}")
    public ItemDto getItem(@PathVariable Long itemId) {
        log.info("REST request to get Item : {}", itemId);
        return itemService.findOne(itemId);
    }

    /**
     * {@code DELETE  /:id} : delete the "id" item.
     *
     * @param id the id of the itemDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable Long id) {
        log.debug("REST request to delete Item : {}", id);
        itemService.delete(id);
    }
}
