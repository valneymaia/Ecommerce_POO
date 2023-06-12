package Dados;


public abstract class Cartao {

    private String nome;
    private String CPF;
    private int numero;
    private float limite;
    private static float fatura;


    public Cartao(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
        this.numero = 12346789;
    }

    public abstract void debitar(float valor);


    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return this.CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getLimite() {return this.limite;}
    public void setLimite(float limite) {
        this.limite = limite;
    }

    public float getFatura() {
        return fatura;
    }
    public void setFatura(float fatura) {
        this.fatura = fatura;
    }

}
