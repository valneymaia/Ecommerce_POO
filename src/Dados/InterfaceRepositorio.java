package Dados;

import Excecoes.DuplicateProductCodeException;

public interface InterfaceRepositorio {

    void adicionarProduto(Produto produto) throws DuplicateProductCodeException;
    int remover();
    int remover(String nome);
    int alterarProduto(String nome, float novoPreco);
    String printar();

}
