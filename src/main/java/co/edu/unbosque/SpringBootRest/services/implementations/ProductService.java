package co.edu.unbosque.SpringBootRest.services.implementations;

import co.edu.unbosque.SpringBootRest.dtos.MakerDTO;
import co.edu.unbosque.SpringBootRest.dtos.ProductDTO;
import co.edu.unbosque.SpringBootRest.entities.Maker;
import co.edu.unbosque.SpringBootRest.entities.Product;
import co.edu.unbosque.SpringBootRest.persistance.interfaces.IProductDAO;
import co.edu.unbosque.SpringBootRest.services.interfaces.IProductService;
import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {


    private final IProductDAO productDAO;

    private final ModelMapper modelMapper;

    private final EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(IProductDAO productDAO, ModelMapper modelMapper, EntityManager entityManager) {
        this.productDAO = productDAO;
        this.modelMapper = modelMapper;
        this.entityManager = entityManager;
    }

    @Override
    public void create(ProductDTO productDTO) {
        Maker maker = entityManager.getReference(Maker.class, productDTO.getMakerDTO().getId());
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(maker)
                .build();
        productDAO.create(product);
        logger.info("Everything went just fine!");
    }

    @Override
    public Optional<ProductDTO> readById(Long id) {
        Product product = productDAO.readById(id).get();
        ProductDTO productDTO = ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .makerDTO(modelMapper.map(product.getMaker(), MakerDTO.class))
                .build();
        return Optional.ofNullable(productDTO);
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
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .makerDTO(modelMapper.map(product.getMaker(), MakerDTO.class))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> readAll() {
        return productDAO.readAll()
                .stream()
                .map( product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .makerDTO(modelMapper.map(product.getMaker(), MakerDTO.class))
                        .build())
                .collect(Collectors.toList());
    }
}
