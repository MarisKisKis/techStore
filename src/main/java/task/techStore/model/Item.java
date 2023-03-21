package task.techStore.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String name;

    @Size(max = 200)
    @Column(name = "description", length = 200)
    private String description;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_content_type")
    private String imageContentType;

    @NotNull
    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "shop_order_order_id")
    private Order order;

}
