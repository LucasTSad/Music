package streaming;

import streaming.abstracao.MusicaAvulsa;
import streaming.abstracao.Playlist;
import streaming.implementacao.Spotify;
import streaming.implementacao.AppleMusic;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Musica Avulsa no Spotify ===");
        MusicaAvulsa m1 = new MusicaAvulsa(new Spotify(), "Blinding Lights", "The Weeknd", 3.5);
        m1.reproduzir("Blinding Lights");
        m1.pausar("Blinding Lights");
        m1.exibirInfo();

        System.out.println("=== Musica Avulsa no Apple Music ===");
        MusicaAvulsa m2 = new MusicaAvulsa(new AppleMusic(), "Blinding Lights", "The Weeknd", 3.5);
        m2.reproduzir("Blinding Lights");
        m2.pausar("Blinding Lights");
        m2.exibirInfo();

        System.out.println("=== Playlist no Spotify ===");
        Playlist pl1 = new Playlist(new Spotify(), "Top Hits 2024", 20, 72.0);
        pl1.reproduzir("Top Hits 2024");
        pl1.embaralhar();
        pl1.exibirInfo();

        System.out.println("=== Playlist no Apple Music ===");
        Playlist pl2 = new Playlist(new AppleMusic(), "Top Hits 2024", 20, 72.0);
        pl2.reproduzir("Top Hits 2024");
        pl2.embaralhar();
        pl2.exibirInfo();
    }
}
