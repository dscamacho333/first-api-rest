package co.edu.unbosque.SpringBootRest.controllers.interfaces;

import co.edu.unbosque.SpringBootRest.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/product")
public interface IProductAPI {

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody ProductDTO productDTO);

    @GetMapping("read/{id}")
    ResponseEntity<?> readById(@PathVariable Long id);

    @PutMapping("/update")
    ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductDTO productDTO);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id);

    @GetMapping("/readAll")
    ResponseEntity<?> readAll();

}
