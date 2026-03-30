package streaming.abstracao;

import streaming.implementacao.Spotify;
import streaming.implementacao.AppleMusic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    void spotifyDeveCalcularCustoExtraParaPlaylist() {
        Playlist playlist = new Playlist(new Spotify(), "Chill Vibes", 10, 40.0);
        assertTrue(playlist.getCustoExtra() > 0);
    }

    @Test
    void appleMusicNaoDeveCobrarCustoExtraParaPlaylist() {
        Playlist playlist = new Playlist(new AppleMusic(), "Chill Vibes", 10, 40.0);
        assertEquals(0.0, playlist.getCustoExtra());
    }

    @Test
    void duracaoTotalDeveEstarCorreta() {
        Playlist playlist = new Playlist(new Spotify(), "Workout Mix", 12, 55.0);
        assertEquals(55.0, playlist.getDuracaoTotal());
    }
}
