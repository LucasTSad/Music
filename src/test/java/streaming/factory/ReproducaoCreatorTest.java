package streaming.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import streaming.abstracao.MusicaAvulsa;
import streaming.abstracao.Playlist;
import streaming.abstracao.Reproducao;
import streaming.implementacao.AppleMusic;
import streaming.implementacao.Spotify;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Padrão Factory Method – ReproducaoCreator")
class ReproducaoCreatorTest {

    @Test
    @DisplayName("MusicaAvulsaCreator deve retornar instância não nula")
    void musicaAvulsaCreatorDeveRetornarInstanciaValida() {
        ReproducaoCreator creator = new MusicaAvulsaCreator(
                new Spotify(), "Blinding Lights", "The Weeknd", 3.5);

        Reproducao reproducao = creator.criarReproducao();

        assertNotNull(reproducao);
    }

    @Test
    @DisplayName("MusicaAvulsaCreator deve produzir instância do tipo MusicaAvulsa")
    void musicaAvulsaCreatorDeveProuzirTipoCorreto() {
        ReproducaoCreator creator = new MusicaAvulsaCreator(
                new Spotify(), "Levitating", "Dua Lipa", 3.2);

        Reproducao reproducao = creator.criarReproducao();

        assertInstanceOf(MusicaAvulsa.class, reproducao,
                "O produto criado deve ser uma MusicaAvulsa");
    }

    @Test
    @DisplayName("MusicaAvulsaCreator com Spotify deve preservar duração")
    void musicaAvulsaCreatorDevePreservarDuracao() {
        double duracao = 4.0;
        MusicaAvulsaCreator creator = new MusicaAvulsaCreator(
                new Spotify(), "Shape of You", "Ed Sheeran", duracao);

        MusicaAvulsa musica = (MusicaAvulsa) creator.criarReproducao();

        assertEquals(duracao, musica.getDuracao());
    }

    @Test
    @DisplayName("MusicaAvulsaCreator com Spotify deve cobrar custo extra")
    void musicaAvulsaCreatorSpotifyDeveCobrarCustoExtra() {
        MusicaAvulsaCreator creator = new MusicaAvulsaCreator(
                new Spotify(), "Starboy", "The Weeknd", 4.0);

        MusicaAvulsa musica = (MusicaAvulsa) creator.criarReproducao();

        assertTrue(musica.getCustoExtra() > 0);
    }

    @Test
    @DisplayName("MusicaAvulsaCreator com Apple Music não deve cobrar custo extra")
    void musicaAvulsaCreatorAppleMusicNaoDeveCobrarCustoExtra() {
        MusicaAvulsaCreator creator = new MusicaAvulsaCreator(
                new AppleMusic(), "Starboy", "The Weeknd", 4.0);

        MusicaAvulsa musica = (MusicaAvulsa) creator.criarReproducao();

        assertEquals(0.0, musica.getCustoExtra());
    }

    @Test
    @DisplayName("iniciarReproducao() deve retornar string com nome do creator")
    void musicaAvulsaCreatorIniciarReproducaoDeveConterNomeCreator() {
        ReproducaoCreator creator = new MusicaAvulsaCreator(
                new Spotify(), "Halo", "Beyoncé", 4.4);

        String resultado = creator.iniciarReproducao("Halo");

        assertTrue(resultado.contains("MusicaAvulsaCreator"),
                "O resultado deve identificar o creator utilizado");
    }

    @Test
    @DisplayName("PlaylistCreator deve retornar instância não nula")
    void playlistCreatorDeveRetornarInstanciaValida() {
        ReproducaoCreator creator = new PlaylistCreator(
                new Spotify(), "Top Hits", 10, 40.0);

        assertNotNull(creator.criarReproducao());
    }

    @Test
    @DisplayName("PlaylistCreator deve produzir instância do tipo Playlist")
    void playlistCreatorDeveProuzirTipoCorreto() {
        ReproducaoCreator creator = new PlaylistCreator(
                new AppleMusic(), "Chill Vibes", 8, 32.0);

        Reproducao reproducao = creator.criarReproducao();

        assertInstanceOf(Playlist.class, reproducao,
                "O produto criado deve ser uma Playlist");
    }

    @Test
    @DisplayName("PlaylistCreator deve preservar duração total")
    void playlistCreatorDevePreservarDuracaoTotal() {
        double duracaoTotal = 55.0;
        PlaylistCreator creator = new PlaylistCreator(
                new Spotify(), "Workout Mix", 12, duracaoTotal);

        Playlist playlist = (Playlist) creator.criarReproducao();

        assertEquals(duracaoTotal, playlist.getDuracaoTotal());
    }

    @Test
    @DisplayName("PlaylistCreator com Spotify deve cobrar custo extra")
    void playlistCreatorSpotifyDeveCobrarCustoExtra() {
        PlaylistCreator creator = new PlaylistCreator(
                new Spotify(), "Evening Mix", 15, 60.0);

        Playlist playlist = (Playlist) creator.criarReproducao();

        assertTrue(playlist.getCustoExtra() > 0);
    }

    @Test
    @DisplayName("PlaylistCreator com Apple Music não deve cobrar custo extra")
    void playlistCreatorAppleMusicNaoDeveCobrarCustoExtra() {
        PlaylistCreator creator = new PlaylistCreator(
                new AppleMusic(), "Evening Mix", 15, 60.0);

        Playlist playlist = (Playlist) creator.criarReproducao();

        assertEquals(0.0, playlist.getCustoExtra());
    }

    @Test
    @DisplayName("iniciarReproducao() deve retornar string com nome do creator")
    void playlistCreatorIniciarReproducaoDeveConterNomeCreator() {
        ReproducaoCreator creator = new PlaylistCreator(
                new AppleMusic(), "Jazz Nights", 20, 80.0);

        String resultado = creator.iniciarReproducao("Jazz Nights");

        assertTrue(resultado.contains("PlaylistCreator"),
                "O resultado deve identificar o creator utilizado");
    }

    @Test
    @DisplayName("Creators distintos devem produzir tipos distintos de Reproducao")
    void creatorsDiferentesDevemProuzirTiposDistintos() {
        ReproducaoCreator musicaCreator  = new MusicaAvulsaCreator(
                new Spotify(), "Halo", "Beyoncé", 4.4);
        ReproducaoCreator playlistCreator = new PlaylistCreator(
                new Spotify(), "Pop Mix", 10, 45.0);

        Reproducao musica   = musicaCreator.criarReproducao();
        Reproducao playlist = playlistCreator.criarReproducao();

        assertNotEquals(musica.getClass(), playlist.getClass(),
                "MusicaAvulsa e Playlist são tipos distintos");
    }

    @Test
    @DisplayName("Cada chamada a criarReproducao() deve gerar uma nova instância")
    void criarReproducaoDeveGerarNovaInstanciaACadaChamada() {
        ReproducaoCreator creator = new MusicaAvulsaCreator(
                new Spotify(), "Dynamite", "BTS", 3.4);

        Reproducao r1 = creator.criarReproducao();
        Reproducao r2 = creator.criarReproducao();

        assertNotSame(r1, r2, "Cada criação deve retornar um objeto diferente");
    }
}
