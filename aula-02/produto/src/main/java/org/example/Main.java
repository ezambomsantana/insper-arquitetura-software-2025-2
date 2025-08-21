package org.example;

public class Main {
    public static void main(String[] args) {


        GerenciarProduto gerenciarProduto = new GerenciarProduto();
        String opcao = "0";
        while (!opcao.equals("6")) {
            System.out.println("""
                        1 - Cadastrar produto
                        2 - Listar produtos
                        3 - Aumentar Preço
                        4 - Mudar estoque
                        5 - Excluir produto
                    """);

            opcao = System.console().readLine();

            if (opcao.equals("1")) {

                String nome = System.console().readLine("Digite o nome:");
                String preco = System.console().readLine("Digite o preço:");
                String quantidade = System.console().readLine("Digite a quatidade:");

                gerenciarProduto.cadastrarProduto(nome, preco, quantidade);

            }

            if (opcao.equals("2")) {
                gerenciarProduto.listarProdutos();
            }


            if (opcao.equals("3")) {
                String nome = System.console().readLine("Digite o nome: ");
                String porcentagem = System.console().readLine("Digite a porcentagem do aumento: ");
                gerenciarProduto.aumentarPreco(nome, porcentagem);
            }


            if (opcao.equals("4")) {
                String nome = System.console().readLine("Digite o nome: ");
                String quantidade = System.console().readLine("Digite a quantidade: ");
                gerenciarProduto.aumentarEstoque(nome, quantidade);
            }


            if (opcao.equals("5")) {
                String nome = System.console().readLine("Digite o nome: ");
                gerenciarProduto.excluirProduto(nome);
            }

        }
    }
}