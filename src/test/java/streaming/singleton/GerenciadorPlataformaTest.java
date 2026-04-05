package streaming.singleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import streaming.implementacao.AppleMusic;
import streaming.implementacao.Spotify;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Padrão Singleton – GerenciadorPlataforma")
class GerenciadorPlataformaTest {

    @BeforeEach
    void setUp() {
        GerenciadorPlataforma.resetarInstancia();
    }

    @Test
    @DisplayName("Duas chamadas a getInstancia() devem retornar o mesmo objeto")
    void deveRetornarMesmaInstancia() {
        GerenciadorPlataforma a = GerenciadorPlataforma.getInstancia();
        GerenciadorPlataforma b = GerenciadorPlataforma.getInstancia();

        assertSame(a, b, "O Singleton deve retornar sempre a mesma referência");
    }

    @Test
    @DisplayName("A instância não pode ser nula")
    void instanciaNaoDeveSerNula() {
        assertNotNull(GerenciadorPlataforma.getInstancia());
    }

    @Test
    @DisplayName("Alteração de plataforma em uma referência deve refletir em outra")
    void estadoDeveSerCompartilhado() {
        GerenciadorPlataforma gerenciador1 = GerenciadorPlataforma.getInstancia();
        GerenciadorPlataforma gerenciador2 = GerenciadorPlataforma.getInstancia();

        gerenciador1.setPlataformaAtiva(new AppleMusic());

        assertEquals("Apple Music", gerenciador2.getPlataformaAtiva().getNome(),
                "A mudança em gerenciador1 deve ser visível em gerenciador2");
    }

    @Test
    @DisplayName("Plataforma padrão deve ser Spotify")
    void plataformaPadraoDeveSerSpotify() {
        GerenciadorPlataforma gerenciador = GerenciadorPlataforma.getInstancia();
        assertEquals("Spotify", gerenciador.getPlataformaAtiva().getNome());
    }

    @Test
    @DisplayName("Contador deve iniciar em zero")
    void contadorDeveIniciarEmZero() {
        assertEquals(0, GerenciadorPlataforma.getInstancia().getTotalReproducoes());
    }

    @Test
    @DisplayName("Cada registrarReproducao() deve incrementar o contador")
    void contadorDeveIncrementar() {
        GerenciadorPlataforma gerenciador = GerenciadorPlataforma.getInstancia();
        gerenciador.registrarReproducao();
        gerenciador.registrarReproducao();
        gerenciador.registrarReproducao();

        assertEquals(3, gerenciador.getTotalReproducoes());
    }

    @Test
    @DisplayName("Incrementos em referências distintas devem acumular no mesmo contador")
    void contadorDeveAcumularEntreReferencias() {
        GerenciadorPlataforma g1 = GerenciadorPlataforma.getInstancia();
        GerenciadorPlataforma g2 = GerenciadorPlataforma.getInstancia();

        g1.registrarReproducao();
        g2.registrarReproducao();

        assertEquals(2, g1.getTotalReproducoes(),
                "Ambas as referências apontam para o mesmo Singleton");
    }

    @Test
    @DisplayName("resetarContador() deve zerar o total de reproduções")
    void deveResetarContador() {
        GerenciadorPlataforma gerenciador = GerenciadorPlataforma.getInstancia();
        gerenciador.registrarReproducao();
        gerenciador.registrarReproducao();
        gerenciador.resetarContador();

        assertEquals(0, gerenciador.getTotalReproducoes());
    }

    @Test
    @DisplayName("Deve permitir trocar a plataforma ativa para Apple Music")
    void deveTrocarPlataformaParaAppleMusic() {
        GerenciadorPlataforma gerenciador = GerenciadorPlataforma.getInstancia();
        gerenciador.setPlataformaAtiva(new AppleMusic());

        assertEquals("Apple Music", gerenciador.getPlataformaAtiva().getNome());
    }

    @Test
    @DisplayName("Deve permitir trocar a plataforma ativa de volta para Spotify")
    void deveTrocarPlataformaParaSpotify() {
        GerenciadorPlataforma gerenciador = GerenciadorPlataforma.getInstancia();
        gerenciador.setPlataformaAtiva(new AppleMusic());
        gerenciador.setPlataformaAtiva(new Spotify());

        assertEquals("Spotify", gerenciador.getPlataformaAtiva().getNome());
    }
}
