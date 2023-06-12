package Teste;
import java.util.Scanner;

import Dados.*;
import Excecoes.*;


public class Main{

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Fachada fachada = new Fachada();


        int escolha;
        int escolha3, quantidade;
        do {
            menu();

            escolha = getInt();

            switch (escolha) {
                case 1:
                    if(fachada.estoque.isEmpty()) {
                        System.out.println("Estoque vazio.");
                        continue; // Ignora a compra
                    }

                    System.out.println(fachada.estoque.printar());
                    System.out.print("Digite a opção desejada:\n(1) Comprar por nome\n(2) Comprar por código de barras\n");
                    int escolha2 = getInt();
                    teclado.nextLine();

                    if (escolha2 == 1) {
                        for(;;) {
                            System.out.print("Nome: [0] para finalizar ");
                            String nome = teclado.nextLine();

                            if(nome.strip().equals("0"))
                                break;
                            System.out.print("Quantidade: ");
                            quantidade = getInt();

                            if(quantidade >= 0) {
                                try {
                                    fachada.c1.adicionarAoCarrinho(fachada.estoque.estoque, nome, quantidade);
                                }
                                catch (DuplicateProductInShoppingCartException | ProductNotFoundException ex) {
                                    System.out.println(ex);
                                }
                            }
                            teclado.nextLine();
                        }
                        System.out.println(fachada.c1.finalizarCompra());
                    }

                    else if (escolha2 == 2) {
                        for(;;) {
                            System.out.print("Codigo: [0] para finalizar ");
                            int codigo = getInt();

                            if(codigo == 0)
                                break;
                            System.out.print("Quantidade: ");
                            quantidade = getInt();

                            fachada.c1.adicionarAoCarrinho(fachada.estoque.estoque, codigo, quantidade);
                        }
                        System.out.println(fachada.c1.finalizarCompra());
                    }

                    else {
                        System.out.println("opçao inválida.");
                    }
                    break;
                case 2:
                    System.out.println(fachada.c1);
                    break;

                case 3:
                    System.out.print("Deseja ser vip, pagando 40 reais e ganhar 20% descontos? \n(1) Sim, (2) Não: ");
                    escolha3 = getInt();
                    teclado.nextLine();

                    if (escolha3 == 1) {
                        if(fachada.c1.tornarVIP()) {
                            System.out.println("VIP ativado com sucesso!");
                        }
                        else {
                            System.out.println("Você já é VIP; a ativação não é necessária.");
                        }
                    }
                    else {
                        System.out.println("Opçao inválida.");
                    }
                    break;

                case 4:
                    if(fachada.c1.cancelarVIP()) {
                        System.out.println("VIP cancelado com sucesso.");
                    }
                    else {
                        System.out.println("Você não é VIP; não é necessário cancelar.");
                    }
                    break;

                case 5:
                    fachada.suporte1.alterarEstoque(fachada.estoque);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (escolha != 6);
    }


    public static void menu() {
        System.out.println("""
                \n========= ECOMMERCE RV ==========
                ======== MENU DE OPÇÕES =========
                1. Comprar produto
                2. Consultar Perfil
                3. Assinar  vip
                4. Cancelar vip
                5. Modificar estoque(Suporte)
                6. Sair
                =================================\s
                """);
    }


    public static int getInt() {
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
}
