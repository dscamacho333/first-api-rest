package co.edu.unbosque.SpringBootRest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name" )
    @NotBlank(message = "Product must have a name.")
    private String name;
    @Column(name = "price" )
    @NotNull(message = "Product must have a price.")
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "maker_id", nullable = false)
    private Maker maker;
}
