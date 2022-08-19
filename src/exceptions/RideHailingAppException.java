package exceptions;

public class RideHailingAppException extends RuntimeException{
    public RideHailingAppException(String message){
        super(message);
    }
    public RideHailingAppException(){

    }
    public RideHailingAppException(Throwable cause){
        super(cause);
    }

    public RideHailingAppException(String message,Throwable cause){
        super(message, cause);
    }
}
