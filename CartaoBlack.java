package Dados;


public class CartaoBlack extends Cartao {

    public CartaoBlack(String nome, String CPF, float salario) {
        super(nome, CPF);
        this.setLimite(salario  / 2 - getFatura());
    }

    @Override
    public void debitar(float valor) {
        setLimite(getLimite() - valor * 0.8f);
        setFatura(getFatura() + valor * 0.8f);
    }

}