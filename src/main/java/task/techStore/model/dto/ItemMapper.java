package task.techStore.model.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import task.techStore.model.Item;

@Component
public class ItemMapper {

    public static Item toItem(ItemDto dto) {
        return Item.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .imageContentType(dto.getImageContentType())
                .price(dto.getPrice())
                .build();
    }

    public static ItemDto toItemDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .image(item.getImage())
                .imageContentType(item.getImageContentType())
                .price(item.getPrice())
                .build();
    }
}
