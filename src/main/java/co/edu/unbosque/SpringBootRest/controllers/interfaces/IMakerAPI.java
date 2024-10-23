package co.edu.unbosque.SpringBootRest.controllers.interfaces;

import co.edu.unbosque.SpringBootRest.dtos.MakerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/maker")
public interface IMakerAPI {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody MakerDTO makerDTO);

    @GetMapping("/read/{id}")
    ResponseEntity<?> readById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@PathVariable Long id, @RequestBody MakerDTO makerDTO);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id);

    @GetMapping("/readAll")
    ResponseEntity<?> readAll();


}
