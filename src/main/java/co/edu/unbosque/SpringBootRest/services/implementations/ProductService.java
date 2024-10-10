package co.edu.unbosque.SpringBootRest.services.implementations;

import co.edu.unbosque.SpringBootRest.entities.Product;
import co.edu.unbosque.SpringBootRest.persistance.interfaces.IProductDAO;
import co.edu.unbosque.SpringBootRest.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO productDAO;

    @Override
    public void create(Product product) {
        productDAO.create(product);
    }

    @Override
    public Optional<Product> readById(Long id) {
        return productDAO.readById(id);
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<Product> readByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productDAO.readByPriceRange(minPrice, maxPrice);
    }

    @Override
    public List<Product> readAll() {
        return productDAO.readAll();
    }
}
