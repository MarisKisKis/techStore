package task.techStore.model.dto;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ItemDto {
    private long id;
    @NotBlank
    private String name;
    private String description;
    private byte[] image;
    private String imageContentType;
    private double price;
}
