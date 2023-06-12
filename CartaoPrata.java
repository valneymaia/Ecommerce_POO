package Dados;


public class CartaoPrata extends Cartao {

    public CartaoPrata(String nome, String CPF, float salario) {
        super(nome, CPF);
        this.setLimite(salario  / 5 - getFatura());
    }

    @Override
    public void debitar(float valor) {
        setLimite(getLimite() - valor);
        setFatura(getFatura() + valor);
    }

}