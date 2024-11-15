package co.edu.unbosque.SpringBootRest.exceptions.handler;

import co.edu.unbosque.SpringBootRest.dtos.ErrorDTO;
import co.edu.unbosque.SpringBootRest.exceptions.exceptions.EntityNotCreatedException;
import co.edu.unbosque.SpringBootRest.exceptions.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
//ResponseEntityHandler is the predefined class of SpringBoot to handle exceptions. It already has methods to handle exceptions and validations.
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotCreatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDTO> entityNotCreatedExceptionHandler(EntityNotCreatedException exception){
        ErrorDTO error = new ErrorDTO(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDTO> entityNotFoundExceptionHandler(EntityNotFoundException exception){
        ErrorDTO error = new ErrorDTO(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    //Override the method to handle a not valid argument from ResponseEntityHandler extended class.
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
       //Create a HashMap to store every validation error
        Set<String> validationErrors = new HashSet<>();
        //Get the list of field errors and iterate over it to save each error into the previously created hashmap.(Key: Violated field, Value: Error message (from the validation) )
        ex
                .getBindingResult()
                .getAllErrors()
                .forEach(

                        (error) -> {
                            var fieldName = ((FieldError) error).getField();
                            var errorMessage = error.getDefaultMessage();
                            String message = "Error on field: " + fieldName.toUpperCase()  + ". Message: " + errorMessage ;
                            validationErrors.add(message);
                        }

                        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrors);
    }
}
