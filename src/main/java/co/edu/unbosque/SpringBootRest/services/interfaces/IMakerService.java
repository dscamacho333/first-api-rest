package co.edu.unbosque.SpringBootRest.services.interfaces;

import co.edu.unbosque.SpringBootRest.dtos.MakerDTO;
import java.util.List;
import java.util.Optional;

public interface IMakerService {

    void create(MakerDTO makerDTO);
    Optional<MakerDTO> readById(Long id);
    void update(MakerDTO makerDTO);
    void deleteById(Long id);
    List<MakerDTO> readAll();

}
