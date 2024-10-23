package co.edu.unbosque.SpringBootRest.services.implementations;

import co.edu.unbosque.SpringBootRest.dtos.MakerDTO;
import co.edu.unbosque.SpringBootRest.dtos.ProductDTO;
import co.edu.unbosque.SpringBootRest.entities.Maker;
import co.edu.unbosque.SpringBootRest.entities.Product;
import co.edu.unbosque.SpringBootRest.exceptions.exceptions.EmptyCollectionException;
import co.edu.unbosque.SpringBootRest.exceptions.exceptions.EntityNotFoundException;
import co.edu.unbosque.SpringBootRest.persistance.interfaces.IMakerDAO;
import co.edu.unbosque.SpringBootRest.services.interfaces.IMakerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MakerService implements IMakerService {


    private final IMakerDAO makerDAO;


    private final  ModelMapper modelMapper;

    @Autowired
    public MakerService(IMakerDAO makerDAO, ModelMapper modelMapper) {
        this.makerDAO = makerDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(MakerDTO makerDTO) {
       Maker maker = Maker.builder()
               .name(makerDTO.getName())
               .productList
                       (makerDTO
                       .getProductListDTO()
                       .stream()
                       .map(p -> modelMapper.map(p, Product.class))
                       .toList()
                       )
               .build();
       makerDAO.create(maker);
    }

    @Override
    public Optional<MakerDTO> readById(Long id) {
        Maker maker  = makerDAO
                .readById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maker was not found!"));

        MakerDTO makerDTO = MakerDTO.builder()
                .id(maker.getId())
                .name(maker.getName())
                .productListDTO
                        (maker
                        .getProductList()
                        .stream()
                        .map(p -> modelMapper.map(p, ProductDTO.class))
                        .collect(Collectors.toList())
                        )
                .build();

        return Optional.of(makerDTO);
    }

    @Override
    public void update(MakerDTO makerDTO) {

    }

    @Override
    public void deleteById(Long id) {
        readById(id);
        makerDAO.deleteById(id);
    }

    @Override
    public List<MakerDTO> readAll() {

        List<Maker> makers = makerDAO.readAll();
        if(makers.isEmpty()){
            throw  new EmptyCollectionException("There are no makers in the data base");
        }

        List<MakerDTO> makersDTO = makers
                .stream()
                .map( maker ->  MakerDTO.builder()
                                .id(maker.getId())
                                .name(maker.getName())
                                .productListDTO
                                        (maker
                                        .getProductList()
                                        .stream()
                                        .map(p -> modelMapper.map(p, ProductDTO.class))
                                        .collect(Collectors.toList())
                                        )
                                .build())
                .collect(Collectors.toList());

        return makersDTO;
    }

}
