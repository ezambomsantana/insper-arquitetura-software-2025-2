package org.example;

import java.util.ArrayList;

public class GerenciarProduto {

    ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(String nome, String preco, String quantidade) {
        Produto produto = new Produto();
        produto.nome = nome;
        produto.preco = Double.parseDouble(preco);
        produto.quantidade = Integer.parseInt(quantidade);

        produtos.add(produto);
    }

    public void listarProdutos() {

        for (Produto produto : produtos) {
            System.out.println("--- Prooduto ---");
            System.out.println(produto.nome);
            System.out.println(produto.quantidade);
            System.out.println(produto.preco);
        }

    }

    public void excluirProduto(String nome) {

        Produto produtoExcluir = null;
        for (Produto produto : produtos) {
            if (produto.nome.equals(nome)) {
                produtoExcluir = produto;
            }
        }
        produtos.remove(produtoExcluir);

        //produtos.removeIf(p -> p.nome.equals(nome));


    }

    public void aumentarPreco(String nome, String porcentagem) {
        for (Produto produto : produtos) {
            if (produto.nome.equals(nome)) {
                produto.aumentarPreco(Double.parseDouble(porcentagem));
            }
        }
    }

    public void aumentarEstoque(String nome, String aumento) {
        for (Produto produto : produtos) {
            if (produto.nome.equals(nome)) {
                produto.alterarEstoque(Integer.parseInt(aumento));
            }
        }
    }

}
