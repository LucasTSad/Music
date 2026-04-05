package streaming.factory;

import streaming.abstracao.Playlist;
import streaming.abstracao.Reproducao;
import streaming.implementacao.PlataformaImplementacao;

public class PlaylistCreator extends ReproducaoCreator {

    private final PlataformaImplementacao plataforma;
    private final String nome;
    private final int quantidadeMusicas;
    private final double duracaoTotalMinutos;

    public PlaylistCreator(PlataformaImplementacao plataforma,
                           String nome,
                           int quantidadeMusicas,
                           double duracaoTotalMinutos) {
        this.plataforma = plataforma;
        this.nome = nome;
        this.quantidadeMusicas = quantidadeMusicas;
        this.duracaoTotalMinutos = duracaoTotalMinutos;
    }

    @Override
    public Reproducao criarReproducao() {
        return new Playlist(plataforma, nome, quantidadeMusicas, duracaoTotalMinutos);
    }
}
