package co.edu.unbosque.SpringBootRest.repositories;

import co.edu.unbosque.SpringBootRest.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMakerRepository extends CrudRepository<Maker,Long> {
}
