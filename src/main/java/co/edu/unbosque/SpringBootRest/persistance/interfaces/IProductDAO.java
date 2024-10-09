package co.edu.unbosque.SpringBootRest.persistance.interfaces;
import co.edu.unbosque.SpringBootRest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductDAO {

    void create(Product product);
    Optional<Product> readById(Long id);
    void update(Product product);
    void deleteById(Long id);
    List<Product> readByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> readAll();
}
