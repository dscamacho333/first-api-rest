package co.edu.unbosque.SpringBootRest.services.implementations;

import co.edu.unbosque.SpringBootRest.dtos.MakerDTO;
import co.edu.unbosque.SpringBootRest.dtos.ProductDTO;
import co.edu.unbosque.SpringBootRest.entities.Maker;
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
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(modelMapper.map(productDTO.getMakerDTO(), Maker.class))
                .build();
        productDAO.create(product);
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
