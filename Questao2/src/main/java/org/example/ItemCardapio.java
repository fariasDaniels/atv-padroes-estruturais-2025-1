package org.example;

import java.util.List;

public interface ItemCardapio {
    double getPreco();
    void exibir(int nivel);
    List<ItemCardapio> getItens();
}