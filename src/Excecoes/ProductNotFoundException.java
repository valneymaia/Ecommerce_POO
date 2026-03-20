package Excecoes;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String errorMessage) {

        super(errorMessage);
    }
}
