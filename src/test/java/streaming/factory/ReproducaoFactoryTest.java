package streaming.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import streaming.abstracao.MusicaAvulsa;
import streaming.abstracao.Playlist;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Padrão Abstract Factory – ReproducaoFactory")
class ReproducaoFactoryTest {

    @Test
    @DisplayName("SpotifyFactory deve criar MusicaAvulsa não nula")
    void spotifyFactoryDeveCriarMusicaAvulsa() {
        ReproducaoFactory factory = new SpotifyFactory();
        MusicaAvulsa musica = factory.criarMusicaAvulsa("Blinding Lights", "The Weeknd", 3.5);

        assertNotNull(musica, "MusicaAvulsa criada pela SpotifyFactory não deve ser nula");
    }

    @Test
    @DisplayName("SpotifyFactory deve criar Playlist não nula")
    void spotifyFactoryDeveCriarPlaylist() {
        ReproducaoFactory factory = new SpotifyFactory();
        Playlist playlist = factory.criarPlaylist("Top Hits", 10, 40.0);

        assertNotNull(playlist, "Playlist criada pela SpotifyFactory não deve ser nula");
    }

    @Test
    @DisplayName("SpotifyFactory deve identificar plataforma como Spotify")
    void spotifyFactoryDeveIdentificarPlataforma() {
        ReproducaoFactory factory = new SpotifyFactory();

        assertEquals("Spotify", factory.getNomePlataforma());
    }

    @Test
    @DisplayName("MusicaAvulsa do Spotify deve cobrar custo extra")
    void spotifyMusicaAvulsaDeveTerCustoExtra() {
        ReproducaoFactory factory = new SpotifyFactory();
        MusicaAvulsa musica = factory.criarMusicaAvulsa("Levitating", "Dua Lipa", 3.5);

        assertTrue(musica.getCustoExtra() > 0,
                "Spotify deve cobrar custo extra por minuto");
    }

    @Test
    @DisplayName("Playlist do Spotify deve cobrar custo extra")
    void spotifyPlaylistDeveTerCustoExtra() {
        ReproducaoFactory factory = new SpotifyFactory();
        Playlist playlist = factory.criarPlaylist("Workout Mix", 12, 50.0);

        assertTrue(playlist.getCustoExtra() > 0);
    }

    @Test
    @DisplayName("AppleMusicFactory deve criar MusicaAvulsa não nula")
    void appleMusicFactoryDeveCriarMusicaAvulsa() {
        ReproducaoFactory factory = new AppleMusicFactory();
        MusicaAvulsa musica = factory.criarMusicaAvulsa("Bohemian Rhapsody", "Queen", 5.9);

        assertNotNull(musica);
    }

    @Test
    @DisplayName("AppleMusicFactory deve criar Playlist não nula")
    void appleMusicFactoryDeveCriarPlaylist() {
        ReproducaoFactory factory = new AppleMusicFactory();
        Playlist playlist = factory.criarPlaylist("Rock Classics", 15, 60.0);

        assertNotNull(playlist);
    }

    @Test
    @DisplayName("AppleMusicFactory deve identificar plataforma como Apple Music")
    void appleMusicFactoryDeveIdentificarPlataforma() {
        ReproducaoFactory factory = new AppleMusicFactory();

        assertEquals("Apple Music", factory.getNomePlataforma());
    }

    @Test
    @DisplayName("MusicaAvulsa do Apple Music NÃO deve cobrar custo extra")
    void appleMusicMusicaAvulsaNaoDeveTerCustoExtra() {
        ReproducaoFactory factory = new AppleMusicFactory();
        MusicaAvulsa musica = factory.criarMusicaAvulsa("Starboy", "The Weeknd", 4.0);

        assertEquals(0.0, musica.getCustoExtra(),
                "Apple Music não deve cobrar custo extra");
    }

    @Test
    @DisplayName("Playlist do Apple Music NÃO deve cobrar custo extra")
    void appleMusicPlaylistNaoDeveTerCustoExtra() {
        ReproducaoFactory factory = new AppleMusicFactory();
        Playlist playlist = factory.criarPlaylist("Chill Vibes", 8, 35.0);

        assertEquals(0.0, playlist.getCustoExtra());
    }

    @Test
    @DisplayName("Factories diferentes devem produzir plataformas distintas")
    void factoriesDiferentesDevemProuzirPlataformasDistintas() {
        ReproducaoFactory spotifyFactory    = new SpotifyFactory();
        ReproducaoFactory appleMusicFactory = new AppleMusicFactory();

        assertNotEquals(spotifyFactory.getNomePlataforma(),
                appleMusicFactory.getNomePlataforma());
    }

    @Test
    @DisplayName("Custo extra de MusicaAvulsa deve diferir entre factories para mesma duração")
    void custoExtraDeveDiferirEntreFactories() {
        ReproducaoFactory spotifyFactory    = new SpotifyFactory();
        ReproducaoFactory appleMusicFactory = new AppleMusicFactory();

        MusicaAvulsa viaSpotify    = spotifyFactory.criarMusicaAvulsa("Shape of You", "Ed Sheeran", 4.0);
        MusicaAvulsa viaAppleMusic = appleMusicFactory.criarMusicaAvulsa("Shape of You", "Ed Sheeran", 4.0);

        assertNotEquals(viaSpotify.getCustoExtra(), viaAppleMusic.getCustoExtra(),
                "Spotify cobra por minuto; Apple Music não cobra custo extra");
    }

    @Test
    @DisplayName("Duração da MusicaAvulsa deve ser preservada independente da factory")
    void duracaoDeveSerPreservadaPelaFactory() {
        double duracao = 5.2;
        ReproducaoFactory factory = new SpotifyFactory();
        MusicaAvulsa musica = factory.criarMusicaAvulsa("Halo", "Beyoncé", duracao);

        assertEquals(duracao, musica.getDuracao());
    }

    @Test
    @DisplayName("Duração total da Playlist deve ser preservada independente da factory")
    void duracaoTotalPlaylistDeveSerPreservadaPelaFactory() {
        double duracaoTotal = 72.0;
        ReproducaoFactory factory = new AppleMusicFactory();
        Playlist playlist = factory.criarPlaylist("Evening Jazz", 18, duracaoTotal);

        assertEquals(duracaoTotal, playlist.getDuracaoTotal());
    }
}
