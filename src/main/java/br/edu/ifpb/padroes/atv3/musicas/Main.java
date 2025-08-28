package br.edu.ifpb.padroes.atv3.musicas;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.servico.TocadorMusica;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TocadorMusica.StreamMusicaFacade facade = new TocadorMusica.StreamMusicaFacade();

        List<Musica> musicas = facade.buscarTodasAsMusicas();
        System.out.println("Músicas disponíveis: " + musicas.size());


        musicas = facade.buscarTodasAsMusicas();
        System.out.println("Músicas disponíveis: " + musicas.size());


        facade.tocar(musicas.get(0));
        facade.tocar(musicas.get(1));
        facade.tocar(musicas.get(0));


    }
}