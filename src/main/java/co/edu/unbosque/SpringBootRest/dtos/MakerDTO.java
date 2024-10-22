package co.edu.unbosque.SpringBootRest.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {

    private Long id;
    @NotBlank(message = "Maker must have a name.")
    private String name;
    private List<ProductDTO> productListDTO = new ArrayList<>();


}
