package co.edu.unbosque.SpringBootRest.services.implementations;

import co.edu.unbosque.SpringBootRest.dtos.MakerDTO;
import co.edu.unbosque.SpringBootRest.entities.Maker;
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

    @Autowired
    private IMakerDAO makerDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(MakerDTO makerDTO) {
        makerDAO.create(modelMapper.map(makerDTO, Maker.class));
    }

    @Override
    public Optional<MakerDTO> readById(Long id) {
        return Optional.ofNullable(modelMapper.map(makerDAO.readById(id), MakerDTO.class));
    }

    @Override
    public void update(MakerDTO makerDTO) {

    }

    @Override
    public void deleteById(Long id) {
        makerDAO.deleteById(id);
    }

    @Override
    public List<MakerDTO> readAll() {
        return makerDAO.readAll().stream()
                .map(maker -> modelMapper.map(maker, MakerDTO.class))
                .collect(Collectors.toList());
    }
}
