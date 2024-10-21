package co.edu.unbosque.SpringBootRest.exceptions.handler;

import co.edu.unbosque.SpringBootRest.dtos.ErrorDTO;
import co.edu.unbosque.SpringBootRest.exceptions.exceptions.EntityNotCreatedException;
import co.edu.unbosque.SpringBootRest.exceptions.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

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

}
