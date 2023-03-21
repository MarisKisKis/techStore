package task.techStore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.techStore.model.Item;
import task.techStore.model.dto.ItemDto;
import task.techStore.model.dto.ItemMapper;
import task.techStore.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDto save(ItemDto itemDTO) {
        log.debug("Request to save Item");
        Item item = itemMapper.toItem(itemDTO);
        item = itemRepository.save(item);
        long id = item.getId();
        Optional<Item> item1opt = itemRepository.findById(id);
        Item item1 = item1opt.get();
        return itemMapper.toItemDto(item);
    }

    @Override
    public ItemDto update(ItemDto itemDTO) {
        log.debug("Request to update Item : {}", itemDTO);
        Item item = itemMapper.toItem(itemDTO);
        item = itemRepository.save(item);
        return itemMapper.toItemDto(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> findAll() {
        log.debug("Request to get all Items");
        List<Item> allItems = itemRepository.findAll();
        return allItems
                .stream()
                .map(ItemMapper::toItemDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ItemDto findOne(Long id) {
        log.debug("Request to get Item : {}", id);
        Optional<Item> itemOptional = itemRepository.findById(id);
        Item item = itemOptional.get();
        return itemMapper.toItemDto(item);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Item : {}", id);
        itemRepository.deleteById(id);
    }
}
