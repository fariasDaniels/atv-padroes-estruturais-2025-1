package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.ServicoMusica;
import br.edu.ifpb.padroes.atv3.musicas.abcd.ClienteHttpABCD;
import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

import java.util.List;

public class ServicoMusicaABCDAdapter implements ServicoMusica {
    private ClienteHttpABCD cliente;

    public ServicoMusicaABCDAdapter(ClienteHttpABCD cliente) {
        this.cliente = cliente;
    }

    @Override
    public List<Musica> listarMusicas() {
        return cliente.listarMusicas();
    }
}
