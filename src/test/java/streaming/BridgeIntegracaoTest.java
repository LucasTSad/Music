package streaming;

import streaming.abstracao.MusicaAvulsa;
import streaming.abstracao.Playlist;
import streaming.abstracao.Reproducao;
import streaming.implementacao.Spotify;
import streaming.implementacao.AppleMusic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BridgeIntegracaoTest {

    @Test
    void musicaAvulsaAceitaQualquerPlataforma() {
        Reproducao comSpotify    = new MusicaAvulsa(new Spotify(), "Bohemian Rhapsody", "Queen", 5.9);
        Reproducao comAppleMusic = new MusicaAvulsa(new AppleMusic(), "Bohemian Rhapsody", "Queen", 5.9);

        assertNotNull(comSpotify);
        assertNotNull(comAppleMusic);
    }

    @Test
    void playlistAceitaQualquerPlataforma() {
        Reproducao comSpotify    = new Playlist(new Spotify(), "Rock Classics", 15, 60.0);
        Reproducao comAppleMusic = new Playlist(new AppleMusic(), "Rock Classics", 15, 60.0);

        assertNotNull(comSpotify);
        assertNotNull(comAppleMusic);
    }

    @Test
    void mesmaReproducaoTrocaDePlataformaSemMudarLogica() {
        MusicaAvulsa comSpotify    = new MusicaAvulsa(new Spotify(), "Shape of You", "Ed Sheeran", 4.0);
        MusicaAvulsa comAppleMusic = new MusicaAvulsa(new AppleMusic(), "Shape of You", "Ed Sheeran", 4.0);

        assertEquals(comSpotify.getDuracao(), comAppleMusic.getDuracao());
        assertNotEquals(comSpotify.getCustoExtra(), comAppleMusic.getCustoExtra());
    }
}
