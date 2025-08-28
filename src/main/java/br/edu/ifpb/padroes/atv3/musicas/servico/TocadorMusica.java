package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.ServicoMusica;
import br.edu.ifpb.padroes.atv3.musicas.abcd.ClienteHttpABCD;
import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.xpto.ClientHttpXPTO;

import java.util.ArrayList;
import java.util.List;

public class TocadorMusica implements ITocadorMusica {
    @Override
    public void tocarMusica(Musica musica) {
        if (musica == null)
            throw new MusicaNaoEncontradaException();

        System.out.println("Tocando musica: " + musica.titulo());
    }

    public static class StreamMusicaFacade {
        private final ServicoMusica servicoMusica;
        private final ITocadorMusica tocadorMusica;

        public StreamMusicaFacade() {

            ServicoMusica servicoABCD = new ServicoMusicaABCDAdapter(new ClienteHttpABCD());
            ServicoMusica servicoXPTO = new ServicoMusicaXPTOAdapter(new ClientHttpXPTO());


            ServicoMusica servicoCompleto = () -> {
                List<Musica> musicas = new ArrayList<>();
                musicas.addAll(servicoABCD.listarMusicas());
                musicas.addAll(servicoXPTO.listarMusicas());
                return musicas;
            };


            this.servicoMusica = new ServicoMusicaCacheProxy(servicoCompleto);


            this.tocadorMusica = new ContadorMusicasDecorator(new TocadorMusica());
        }

        public List<Musica> buscarTodasAsMusicas() {
            return this.servicoMusica.listarMusicas();
        }

        public void tocar(Musica musica) {
            this.tocadorMusica.tocarMusica(musica);
        }
    }
}
