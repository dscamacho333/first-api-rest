package co.edu.unbosque.SpringBootRest.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IMakerAPI {

    @GetMapping("/find/{id}")
    ResponseEntity<?> readById(@PathVariable Long id);


}
