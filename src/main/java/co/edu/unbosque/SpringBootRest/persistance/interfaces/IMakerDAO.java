package co.edu.unbosque.SpringBootRest.persistance.interfaces;

import co.edu.unbosque.SpringBootRest.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {

    void create(Maker maker);
    Optional<Maker> readById(Long id);
    void update(Maker maker);
    void deleteById(Long id);
    List<Maker> readAll();


}
