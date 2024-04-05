package az.edu.ada.wm2.validationexceptiondemoincomplete.exceptions;

public class MyCustomException extends UserNotFoundException{




    public  MyCustomException(){
        super("a dummy messag");
    }

    public MyCustomException(String msg){
        super(msg);
    }
}
