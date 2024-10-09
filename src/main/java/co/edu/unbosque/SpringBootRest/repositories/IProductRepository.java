package co.edu.unbosque.SpringBootRest.repositories;


import co.edu.unbosque.SpringBootRest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product,Long> {

    //@Query(SELECT P FROM Product p WHERE p.price BETWEEN ?1 AND ?2)
    @Query("SELECT p FROM Product p WHERE p.price >= ?1 AND p.price <= ?2")
    List<Product> readByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

}
