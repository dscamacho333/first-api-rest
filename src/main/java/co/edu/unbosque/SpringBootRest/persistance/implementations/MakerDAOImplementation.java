package co.edu.unbosque.SpringBootRest.persistance.implementations;

import co.edu.unbosque.SpringBootRest.entities.Maker;
import co.edu.unbosque.SpringBootRest.persistance.interfaces.IMakerDAO;
import co.edu.unbosque.SpringBootRest.repositories.IMakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MakerDAOImplementation implements IMakerDAO {

    @Autowired
    private IMakerRepository makerRepository;

    @Override
    public void create(Maker maker) {
        makerRepository.save(maker);
    }

    @Override
    public Optional<Maker> readById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public void update(Maker maker) {

    }

    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }

    @Override
    public List<Maker> readAll() {
        return (List<Maker>) makerRepository.findAll();
    }
}
