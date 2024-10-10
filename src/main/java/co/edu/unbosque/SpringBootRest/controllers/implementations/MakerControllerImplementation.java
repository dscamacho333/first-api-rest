package co.edu.unbosque.SpringBootRest.controllers.implementations;

import co.edu.unbosque.SpringBootRest.controllers.interfaces.IMakerAPI;
import co.edu.unbosque.SpringBootRest.dtos.MakerDTO;
import co.edu.unbosque.SpringBootRest.services.interfaces.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class MakerControllerImplementation implements IMakerAPI {

    @Autowired
    private IMakerService makerService;


    @Override
    public ResponseEntity<?> create(MakerDTO makerDTO) {
        makerService.create(makerDTO);
        return ResponseEntity
                .status(HttpStatusCode
                        .valueOf(205))
                .build();
    }

    @Override
    public ResponseEntity<?> readById(Long id) {
        Optional<MakerDTO> makerDTOOptional = makerService.readById(id);
        return  makerDTOOptional.isPresent() ?
                ( ResponseEntity.ok(makerDTOOptional.get()) )  :  ( ResponseEntity.notFound().build() );
    }

    @Override
    public ResponseEntity<?> update(Long id, MakerDTO makerDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if(!(id == null)){
            makerService.deleteById(id);
            return (ResponseEntity.ok("Maker with ID: " + id + " " + "was deleted successfully."));
        }else{
            return (ResponseEntity.badRequest().build());
        }
    }

    @Override
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(makerService.readAll());
    }
}
