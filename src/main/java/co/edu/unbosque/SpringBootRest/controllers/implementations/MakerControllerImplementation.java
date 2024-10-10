package co.edu.unbosque.SpringBootRest.controllers.implementations;

import co.edu.unbosque.SpringBootRest.controllers.interfaces.IMakerAPI;
import co.edu.unbosque.SpringBootRest.dtos.MakerDTO;
import co.edu.unbosque.SpringBootRest.services.interfaces.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/maker")
public class MakerControllerImplementation implements IMakerAPI {

    @Autowired
    private IMakerService makerService;


    @Override
    public ResponseEntity<?> readById(Long id) {
        Optional<MakerDTO> makerDTOOptional = makerService.readById(id);
        return  makerDTOOptional.isPresent() ?
                (ResponseEntity.ok(makerDTOOptional.get()))  :  (ResponseEntity.notFound().build());
    }
}
