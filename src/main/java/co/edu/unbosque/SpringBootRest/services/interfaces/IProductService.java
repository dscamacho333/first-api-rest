package co.edu.unbosque.SpringBootRest.services.interfaces;

import co.edu.unbosque.SpringBootRest.dtos.ProductDTO;
import co.edu.unbosque.SpringBootRest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    void create(ProductDTO productDTO);
    Optional<ProductDTO> readById(Long id);
    void update(ProductDTO productDTO);
    void deleteById(Long id);
    List<ProductDTO> readByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<ProductDTO> readAll();

}
