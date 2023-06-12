package Repositorio;

import Dados.Produto;
import java.util.ArrayList;
import java.util.List;
import Dados.InterfaceRepositorio;
import  Excecoes.DuplicateProductCodeException;


public class RepositorioProduto implements InterfaceRepositorio {

    public List<Produto> estoque = new ArrayList<>();

    @Override
    public void adicionarProduto (Produto novoProduto) throws DuplicateProductCodeException {

        for(Produto produto : estoque) {
            if(produto.getCodigo() == novoProduto.getCodigo()) {
                throw new DuplicateProductCodeException("Código de produto já utilizado.");
            }
        }
        estoque.add(novoProduto);
    }

    @Override
    public int remover(String nome) {

        if(estoque.isEmpty()) {
                return 0;  //System.out.println("Estoque vazio, não foi possível remover.");
        }

        for(Produto produto : estoque) {
            if(produto.getNome().equalsIgnoreCase(nome)) {
                estoque.remove(produto);
                return 1; // Remoção concluída
            }
        }
        return 2; // Produto não encontrado
    }

    @Override
    public int remover() {

        if(estoque.isEmpty()) {
            return 0; // Estoque vazio
        }
        estoque.clear();
        return 1;
    }

    @Override
    public int alterarProduto(String nome, float novoPreco) {

        if(estoque.isEmpty()) {
            return 0; // Estoque vazio
        }

        for(Produto produto : estoque) {
            if(produto.getNome().equalsIgnoreCase(nome)) {
                produto.setPreco(novoPreco); // Produto alterado
                return 1;
            }
        }
        return 2;
    }

    @Override
    public String printar() {

        if(estoque.isEmpty()) {
            return "Repositório vazio";
        }

        StringBuilder string = new StringBuilder();

        for (Produto a : this.estoque) {
            string.append("Codigo: " + a.getCodigo() + "\t" + a.getNome() +  " \tPreço: " + a.getPreco() + "\n");
        }
        string.append("\n");
        return string.toString();
    }

    public boolean isEmpty() {
        return this.estoque.isEmpty();
    }
}
