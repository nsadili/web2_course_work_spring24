package az.edu.ada.wm2.validationexceptiondemoincomplete.exceptions;

public class MyException extends UserNotFoundException{

    public MyException (String message){
        super(message);
    }

    public MyException(){
        super("Dummy message");
    }

}
