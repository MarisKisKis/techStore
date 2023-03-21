package task.techStore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "shop_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @NotNull
    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @OneToMany(mappedBy = "order",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Item> items = new HashSet<>();
}
