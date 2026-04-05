package streaming.factory;

import streaming.abstracao.MusicaAvulsa;
import streaming.abstracao.Playlist;
import streaming.implementacao.Spotify;

public class SpotifyFactory implements ReproducaoFactory {

    private final Spotify spotify = new Spotify();

    @Override
    public MusicaAvulsa criarMusicaAvulsa(String titulo, String artista, double duracaoMinutos) {
        return new MusicaAvulsa(spotify, titulo, artista, duracaoMinutos);
    }

    @Override
    public Playlist criarPlaylist(String nome, int quantidadeMusicas, double duracaoTotalMinutos) {
        return new Playlist(spotify, nome, quantidadeMusicas, duracaoTotalMinutos);
    }

    @Override
    public String getNomePlataforma() {
        return spotify.getNome();
    }
}
