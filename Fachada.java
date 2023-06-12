package Dados;

import Repositorio.RepositorioProduto;
import Teste.Suporte;

public class Fachada {

    public Suporte suporte1 = new Suporte();
    public Cliente c1 = new Cliente("Seu ze", "400.289.22-0", 1000);
    public RepositorioProduto estoque = new RepositorioProduto();

    public Fachada() {
        c1.criarCartaoPrata();
    }
}
