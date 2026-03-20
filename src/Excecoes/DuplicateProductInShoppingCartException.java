package Excecoes;

public class DuplicateProductInShoppingCartException extends Exception{

    public DuplicateProductInShoppingCartException(String errorMessage) {

        super(errorMessage);
    }
}
