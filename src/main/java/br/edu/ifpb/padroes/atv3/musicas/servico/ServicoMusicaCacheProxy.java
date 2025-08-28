package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.ServicoMusica;
import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.List;

public class ServicoMusicaCacheProxy implements ServicoMusica {
    private ServicoMusica servicoReal;
    private List<Musica> cacheMusicas;

    public ServicoMusicaCacheProxy(ServicoMusica servicoReal) {
        this.servicoReal = servicoReal;
    }

    @Override
    public List<Musica> listarMusicas() {
        if (cacheMusicas == null) {
            System.out.println("Buscando músicas do serviço real e armazenando em cache...");
            cacheMusicas = servicoReal.listarMusicas();
        } else {
            System.out.println("Retornando músicas do cache...");
        }
        return cacheMusicas;
    }
}