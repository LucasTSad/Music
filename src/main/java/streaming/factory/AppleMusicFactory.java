package streaming.factory;

import streaming.abstracao.MusicaAvulsa;
import streaming.abstracao.Playlist;
import streaming.implementacao.AppleMusic;

public class AppleMusicFactory implements ReproducaoFactory {

    private final AppleMusic appleMusic = new AppleMusic();

    @Override
    public MusicaAvulsa criarMusicaAvulsa(String titulo, String artista, double duracaoMinutos) {
        return new MusicaAvulsa(appleMusic, titulo, artista, duracaoMinutos);
    }

    @Override
    public Playlist criarPlaylist(String nome, int quantidadeMusicas, double duracaoTotalMinutos) {
        return new Playlist(appleMusic, nome, quantidadeMusicas, duracaoTotalMinutos);
    }

    @Override
    public String getNomePlataforma() {
        return appleMusic.getNome();
    }
}
