package Dados;

public class Produto {

    private String nome;
    private int codigo;
    private float preco;

    public Produto(String nome, float preco, int codigo) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
    }


    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return this.codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPreco() {
        return this.preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
}