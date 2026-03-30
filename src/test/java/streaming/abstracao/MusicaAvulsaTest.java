package streaming.abstracao;

import streaming.abstracao.MusicaAvulsa;
import streaming.implementacao.Spotify;
import streaming.implementacao.AppleMusic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MusicaAvulsaTest {

    @Test
    void spotifyDeveCalcularCustoExtra() {
        MusicaAvulsa musica = new MusicaAvulsa(new Spotify(), "Levitating", "Dua Lipa", 3.5);
        assertTrue(musica.getCustoExtra() > 0);
    }

    @Test
    void appleMusicNaoDeveCobrarCustoExtra() {
        MusicaAvulsa musica = new MusicaAvulsa(new AppleMusic(), "Levitating", "Dua Lipa", 3.5);
        assertEquals(0.0, musica.getCustoExtra());
    }

    @Test
    void duracaoDeveEstarCorreta() {
        MusicaAvulsa musica = new MusicaAvulsa(new Spotify(), "Starboy", "The Weeknd", 4.0);
        assertEquals(4.0, musica.getDuracao());
    }
}
