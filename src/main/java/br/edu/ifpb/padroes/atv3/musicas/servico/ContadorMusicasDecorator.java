package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.HashMap;
import java.util.Map;

public class ContadorMusicasDecorator implements ITocadorMusica {
    private ITocadorMusica tocador;
    private static final Map<String, Integer> contador = new HashMap<>();

    public ContadorMusicasDecorator(ITocadorMusica tocador) {
        this.tocador = tocador;
    }

    @Override
    public void tocarMusica(Musica musica) {
        tocador.tocarMusica(musica);
        contador.merge(musica.titulo(), 1, Integer::sum);
        System.out.println("Música " + musica.titulo() + " tocada " + contador.get(musica.titulo()) + " vez(es).");
    }
}