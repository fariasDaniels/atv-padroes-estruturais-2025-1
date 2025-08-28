package org.example;

import java.util.ArrayList;
import java.util.List;

public class Combo implements ItemCardapio {
    private String nome;
    private List<ItemCardapio> itens = new ArrayList<>();
    private double desconto; // Desconto em porcentagem (ex: 0.10 para 10%)

    public Combo(String nome, double desconto) {
        this.nome = nome;
        this.desconto = desconto;
    }

    public void adicionar(ItemCardapio item) {
        itens.add(item);
    }

    public void remover(ItemCardapio item) {
        itens.remove(item);
    }

    @Override
    public double getPreco() {
        double precoTotal = 0.0;
        for (ItemCardapio item : itens) {
            precoTotal += item.getPreco();
        }
        return precoTotal * (1 - desconto);
    }

    @Override
    public void exibir(int nivel) {
        System.out.println("  ".repeat(nivel) + "+ Combo: " + nome + " (R$" + String.format("%.2f", getPreco()) + ")");
        for (ItemCardapio item : itens) {
            item.exibir(nivel + 1);
        }
    }

    @Override
    public List<ItemCardapio> getItens() {
        return itens;
    }
}