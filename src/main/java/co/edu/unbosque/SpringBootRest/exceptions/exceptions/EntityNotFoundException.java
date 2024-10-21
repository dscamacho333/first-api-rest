package co.edu.unbosque.SpringBootRest.exceptions.exceptions;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String message){
        super(message);
    }

}
