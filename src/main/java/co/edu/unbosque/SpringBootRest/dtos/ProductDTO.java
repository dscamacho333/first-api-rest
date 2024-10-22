package co.edu.unbosque.SpringBootRest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    @NotBlank(message = "Product must have a name.")
    private String name;
    @NotNull(message = "Product must have a price.")
    private BigDecimal price;
    private MakerDTO makerDTO;

}
