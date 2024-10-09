package co.edu.unbosque.SpringBootRest.persistance.implementations;

import co.edu.unbosque.SpringBootRest.entities.Product;
import co.edu.unbosque.SpringBootRest.persistance.interfaces.IProductDAO;
import co.edu.unbosque.SpringBootRest.repositories.IMakerRepository;
import co.edu.unbosque.SpringBootRest.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOImplementation implements IProductDAO {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> readById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> readByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.readByPriceRange(minPrice,maxPrice);
    }

    @Override
    public List<Product> readAll() {
        return (List<Product>) productRepository.findAll();
    }
}
