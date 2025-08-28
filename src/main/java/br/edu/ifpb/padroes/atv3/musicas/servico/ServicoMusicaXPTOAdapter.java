package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.ServicoMusica;
import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.xpto.ClientHttpXPTO;
import br.edu.ifpb.padroes.atv3.musicas.xpto.Song;

import java.util.List;
import java.util.stream.Collectors;

public class ServicoMusicaXPTOAdapter implements ServicoMusica {
    private ClientHttpXPTO cliente;

    public ServicoMusicaXPTOAdapter(ClientHttpXPTO cliente) {
        this.cliente = cliente;
    }

    @Override
    public List<Musica> listarMusicas() {
        List<Song> songs = cliente.findAll();
        return songs.stream()
                .map(s -> new Musica(s.id(), s.title(), s.artist(), s.year(), s.genre()))
                .collect(Collectors.toList());
    }
}