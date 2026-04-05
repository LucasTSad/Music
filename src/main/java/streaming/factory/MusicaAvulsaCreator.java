package streaming.factory;

import streaming.abstracao.MusicaAvulsa;
import streaming.abstracao.Reproducao;
import streaming.implementacao.PlataformaImplementacao;

public class MusicaAvulsaCreator extends ReproducaoCreator {

    private final PlataformaImplementacao plataforma;
    private final String titulo;
    private final String artista;
    private final double duracaoMinutos;

    public MusicaAvulsaCreator(PlataformaImplementacao plataforma,
                               String titulo,
                               String artista,
                               double duracaoMinutos) {
        this.plataforma = plataforma;
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public Reproducao criarReproducao() {
        return new MusicaAvulsa(plataforma, titulo, artista, duracaoMinutos);
    }
}
