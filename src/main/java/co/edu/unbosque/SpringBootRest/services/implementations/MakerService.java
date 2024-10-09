package co.edu.unbosque.SpringBootRest.services.implementations;

import co.edu.unbosque.SpringBootRest.entities.Maker;
import co.edu.unbosque.SpringBootRest.persistance.interfaces.IMakerDAO;
import co.edu.unbosque.SpringBootRest.services.interfaces.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerService implements IMakerService {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public void create(Maker maker) {

    }

    @Override
    public Optional<Maker> readById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Maker maker) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Maker> readAll() {
        return List.of();
    }
}
