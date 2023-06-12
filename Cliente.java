package Dados;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Excecoes.*;


public class Cliente {

    private String nome;
    private String CPF;
    private float salario;
    private boolean VIP;

    private final Map<Produto, Integer> carrinho = new HashMap<Produto, Integer>();
    private  Cartao meuCartao;

    public Cliente(String nome, String CPF, float salario) {
        this.nome = nome;
        this.CPF = CPF;
        this.salario = salario;
        this.VIP = false;
    }
    
    public void criarCartaoPrata() {
            meuCartao = new CartaoPrata(nome, CPF, salario);
            meuCartao.setNumero(123450678);
    }


    public boolean tornarVIP() {

        if(!isVIP()) {
            meuCartao = new CartaoBlack(this.nome, this.CPF, this.salario);
            meuCartao.debitar(50.0f);
            setVIP(true);

            return true;
        }
        else {
            return false; // Já é VIP
        }
    }


    public boolean cancelarVIP() {

        if (!isVIP()) {
            return false; // Já não é VIP
        }
        else {
            meuCartao = new CartaoPrata(this.nome, this.CPF, this.salario);
            setVIP(false);
            return true; //VIP cancelado
        }
    }


    public String notaFiscal() {

        String numeroString = String.valueOf(meuCartao.getNumero());
        if (numeroString.length() >= 4) {
            String ultimosQuatroDigitos = numeroString.substring(numeroString.length() - 4);
            System.out.println("=====  Nota Fiscal  =====\n Forma de pagamento: Cartao "+ultimosQuatroDigitos);
        }

        return "" +
                "Nome: " + meuCartao.getNome() +
                "\nCPF: " + meuCartao.getCPF() +
                 "\n";
    }


    public void adicionarAoCarrinho (List<Produto> estoque, String nome, int quantidade)
            throws DuplicateProductInShoppingCartException, ProductNotFoundException {

        for(Produto produto : estoque) {
           if(produto.getNome().strip().equalsIgnoreCase(nome)) {
               if(this.carrinho.containsKey(produto)) {
                   throw new DuplicateProductInShoppingCartException("Produto já existe no carrinho 1");
               }
               else {
                   carrinho.put(produto, quantidade);
                   return;
               }
           }
        }
        throw new ProductNotFoundException("Produto não encontrado no estoque.");
    }


    public void adicionarAoCarrinho(List<Produto> estoque, int codigo, int quantidade)
            throws DuplicateProductInShoppingCartException, ProductNotFoundException {

        for(Produto produto : estoque) {
            if(produto.getCodigo() == codigo) {
                if(carrinho.containsKey(produto)) {
                    throw new DuplicateProductInShoppingCartException("Produto já existe no carrinho.");
                }
                else {
                    carrinho.put(produto, quantidade);
                    return;
                }
            }
        }
        throw new ProductNotFoundException("Produto não encontrado no estoque.");
    }


    public String finalizarCompra() {
        Produto produto;
        float total = 0.0f;

        StringBuilder string = new StringBuilder(notaFiscal());

        for(Map.Entry<Produto, Integer> carrinho : this.carrinho.entrySet()) {
            produto = carrinho.getKey();
            string.append(produto.getNome() + "  \t" + " Qtd:" + " "
                    + carrinho.getValue() +  " R$: "+ produto.getPreco() +" unidade ");

            total += produto.getPreco() * carrinho.getValue();
        }

        if(total <= meuCartao.getLimite()) {
            string.append("\nPreço Total: R$" + total + "\nCompra efetuada com sucesso!\n" + "========================\n");
            meuCartao.debitar(total);
        }
        else {
            string.append("\nPreço Total: R$" + total + "\nSaldo insuficiente, compra não efetuada.\n" + "========================\n");
        }

        return string.toString();
    }



    public String getNome() { return nome; }
    public void setNome(String nome) {this.nome = nome; }

    public String getCPF() { return CPF; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    public float getSalario() { return salario; }
    public void setSalario(float salario) { this.salario = salario; }

    public boolean isVIP() { return VIP; }
    public void setVIP(boolean VIP) { this.VIP = VIP; }

    public Cartao getMeuCartao() {return meuCartao;}
    public void setMeuCartao(Cartao meuCartao) { this.meuCartao = meuCartao; }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if(isVIP()) string.append("Seu cartao e vip");
        else string.append("Nao e vip");
        string.append(
                "\nlimite disponivel: " + meuCartao.getLimite()
                + "\nDivida atual: " + meuCartao.getFatura()
                + "\n\nCliente:" +
                "\nnome= '" + nome + '\'' +
                "\nCPF= " + CPF + '\'' +
                ",\nsalario= " + salario +
                "\nVIP= " + VIP +
                '.');
        return  string.toString();
    }
}
