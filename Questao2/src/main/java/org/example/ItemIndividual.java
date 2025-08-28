package org.example;

import java.util.Collections;
import java.util.List;

public class ItemIndividual implements ItemCardapio {
    private String nome;
    private double preco;

    public ItemIndividual(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void exibir(int nivel) {
        System.out.println("  ".repeat(nivel) + "- " + nome + " (R$" + String.format("%.2f", preco) + ")");
    }

    @Override
    public List<ItemCardapio> getItens() {
        return Collections.emptyList();
    }
}