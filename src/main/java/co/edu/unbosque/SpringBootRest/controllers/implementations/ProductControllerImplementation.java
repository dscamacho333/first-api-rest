package co.edu.unbosque.SpringBootRest.controllers.implementations;

import co.edu.unbosque.SpringBootRest.controllers.interfaces.IProductAPI;
import co.edu.unbosque.SpringBootRest.dtos.ProductDTO;
import co.edu.unbosque.SpringBootRest.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductControllerImplementation implements IProductAPI {

    @Autowired
    private IProductService productService;

    @Override
    public ResponseEntity<?> create(ProductDTO productDTO) {
        productService.create(productDTO);
        return ResponseEntity
                .status(HttpStatusCode.
                        valueOf(205))
                .build();
    }

    @Override
    public ResponseEntity<?> readById(Long id) {
        Optional<ProductDTO> productDTOOptional = productService.readById(id);
        return productDTOOptional.isPresent()?
               ( ResponseEntity.ok(productDTOOptional.get()) )  :  ( ResponseEntity.notFound().build() );
    }

    @Override
    public ResponseEntity<?> update(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        if(!(id == null)){
            return ResponseEntity.ok("Product with ID: " + id + " " + "has been deleted successfully.");
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<?> readAll() {
        return (ResponseEntity.ok(productService.readAll()));
    }
}
