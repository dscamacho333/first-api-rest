package co.edu.unbosque.SpringBootRest.exceptions.exceptions;

public class EmptyCollectionException extends RuntimeException{

    public EmptyCollectionException(String message){
        super(message);
    }
}
