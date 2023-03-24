package task.techStore.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;
import task.techStore.model.Item;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Jacksonized
public class OrderDto {

    private long id;
    @NotBlank
    private double totalPrice;

    private Set<Item> items;
    @NotBlank
    private LocalDateTime created;

}
