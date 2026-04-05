package streaming.factory;

import streaming.abstracao.MusicaAvulsa;
import streaming.abstracao.Playlist;

public interface ReproducaoFactory {
    MusicaAvulsa criarMusicaAvulsa(String titulo, String artista, double duracaoMinutos);

    Playlist criarPlaylist(String nome, int quantidadeMusicas, double duracaoTotalMinutos);

    String getNomePlataforma();
}
