package co.edu.unbosque.SpringBootRest.services.implementations;

import co.edu.unbosque.SpringBootRest.dtos.ProductDTO;
import co.edu.unbosque.SpringBootRest.entities.Product;
import co.edu.unbosque.SpringBootRest.persistance.interfaces.IProductDAO;
import co.edu.unbosque.SpringBootRest.services.interfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO productDAO;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(ProductDTO productDTO) {
        productDAO.create(modelMapper.map(productDTO, Product.class));
    }

    @Override
    public Optional<ProductDTO> readById(Long id) {
        return Optional.ofNullable(modelMapper.map(productDAO.readById(id), ProductDTO.class));
    }

    @Override
    public void update(ProductDTO productDTO) {

    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<ProductDTO> readByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productDAO.readByPriceRange(minPrice, maxPrice)
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> readAll() {
        return productDAO.readAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
