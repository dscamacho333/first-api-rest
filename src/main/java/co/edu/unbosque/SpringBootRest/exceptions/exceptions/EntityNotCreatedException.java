package co.edu.unbosque.SpringBootRest.exceptions.exceptions;

public class EntityNotCreatedException extends RuntimeException{

    public EntityNotCreatedException(String message){
        super(message);
    }

}
