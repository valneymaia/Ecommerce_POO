package Teste;

import Dados.Produto;
import Excecoes.DuplicateProductCodeException;
import Repositorio.RepositorioProduto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Suporte {

    static Scanner teclado = new Scanner(System.in);

    public void alterarEstoque(RepositorioProduto estoque) throws IOException {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/Dados/senha.txt"));
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex + "\nArquivo senha.txt não encontrado. Certifique que o arquivo existe.");
            return;
        }

        String senha = reader.readLine();
        reader.close();

        System.out.print("Senha de acesso: ");
        String tentativa = teclado.nextLine();

        if(!tentativa.equals(senha)) {
            System.out.println("Senha incorreta.");
            return;
        }

        for(;;) {
            int resultado;
            menu();
            int escolha = getInt();

            String nome; int codigo;  float preco;
            switch (escolha) {
                case 1:
                    teclado.nextLine();
                    System.out.print("Digite o nome: ");
                    nome = teclado.nextLine();
                    System.out.print("Digite o preço: ");
                    preco = teclado.nextFloat();
                    System.out.print("Digite o código: ");
                    codigo = teclado.nextInt();

                    try {
                        estoque.adicionarProduto(new Produto(nome, preco, codigo));
                    }
                    catch (DuplicateProductCodeException ex) {
                        System.out.println(ex);
                    }

                    break;

                case 2:
                    if(estoque.isEmpty()) {
                        System.out.println("Estoque vazio.");
                        break;
                    }

                    System.out.print("Digite o nome do produto que deseja remover:");
                    teclado.nextLine();
                    nome = teclado.nextLine();

                    resultado = estoque.remover(nome);
                    switch (resultado) {
                        case 0:
                            System.out.println("Estoque Vazio, não foi possível remover.");
                            break;
                        case 1:
                            System.out.println("Produto removido.");
                            break;
                        case 2:
                            System.out.println("Produto não encontrado; não foi possível remover.");
                            break;
                        default:
                            break;
                    }
                    break;

                case 3:
                    resultado = estoque.remover();
                    switch (resultado) {
                        case 0:
                            System.out.println("Estoque Vazio, não foi possível remover.");
                            break;
                        case 1:
                            System.out.println("Produtos removidos.");
                            break;
                        default:
                            break;
                    }
                    break;

                case 4:
                    teclado.nextLine();
                    System.out.print("digite o nome: ");
                    nome = teclado.nextLine();
                    System.out.print("digite o novo preço: ");
                    preco = teclado.nextFloat();

                    estoque.alterarProduto(nome, preco);
                    break;

                case 5:
                    System.out.println(estoque.printar());
                    break;

                case 6:
                    String linha;
                    BufferedReader file;
                    try {
                        file = new BufferedReader(new FileReader("src\\Dados\\produtos.csv"));
                    }
                    catch (FileNotFoundException ex) {
                        System.out.println(ex + "\nArquivo produtos.csv não encontrado. Verifique se o arquivo existe.");
                        return;
                    }

                    while ((linha = file.readLine()) != null)  //Le uma linha
                    {
                        String[] novo = linha.split(","); // Separa strings por vírgula
                        try {
                            estoque.adicionarProduto(new Produto(novo[0], Float.parseFloat(novo[1]), Integer.parseInt(novo[2])));
                        }
                        catch (DuplicateProductCodeException ex) {
                            System.out.println(ex);
                        }
                    }
                    break;

                default:
                    System.out.println("Saindo...");
                    return;
            }
        }
    }

    private int getInt() {
        for(;;) {
            String input = teclado.next();
            try {
                return Integer.parseInt(input);
            }
            catch (NumberFormatException ex) {
                System.out.print("Entrada inválida. Tente novamente: ");
            }
        }
    }
    private void menu() {
        System.out.println("""
                \n1. Adicionar produto
                2. Remover produto por nome
                3. Remover todos os produtos
                4. Alterar preço
                5. Imprimir
                6. Adicionar por txt.
                7. Sair\s
                """);
    }

}
