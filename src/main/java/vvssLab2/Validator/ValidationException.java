package vvssLab2.Validator;

public class ValidationException extends RuntimeException {
    public ValidationException(){}
    public ValidationException(String msg){
        super(msg);
    }
}
