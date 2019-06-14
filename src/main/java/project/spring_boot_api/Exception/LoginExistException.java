package project.spring_boot_api.Exception;

public class LoginExistException extends Exception {

    public LoginExistException(String errorMessage) {
        super(errorMessage);
    }
}
