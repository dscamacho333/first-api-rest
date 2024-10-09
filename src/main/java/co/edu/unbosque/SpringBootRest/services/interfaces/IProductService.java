package co.edu.unbosque.SpringBootRest.services.interfaces;

import co.edu.unbosque.SpringBootRest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    void create(Product product);
    Optional<Product> readById(Long id);
    void update(Product product);
    void deleteById(Long id);
    List<Product> readByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> readAll();

}
