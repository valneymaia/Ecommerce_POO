package Excecoes;

public class DuplicateProductCodeException extends  Exception {

    public DuplicateProductCodeException(String errorMessage) {

        super(errorMessage);
    }
}
