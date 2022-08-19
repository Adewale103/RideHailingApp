package exceptions;

public class UserAlreadyExistException extends RideHailingAppException {
    public UserAlreadyExistException(String message){
        super(message);
    }
    public UserAlreadyExistException(){

    }
    public UserAlreadyExistException(Throwable cause){
        super(cause);
    }

    public UserAlreadyExistException(String message,Throwable cause){
        super(message, cause);
    }
}
