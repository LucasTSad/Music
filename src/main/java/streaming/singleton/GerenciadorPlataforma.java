package streaming.singleton;

import streaming.implementacao.PlataformaImplementacao;
import streaming.implementacao.Spotify;

public class GerenciadorPlataforma {

    private static GerenciadorPlataforma instancia;

    private PlataformaImplementacao plataformaAtiva;
    private int totalReproducoes;

    private GerenciadorPlataforma() {
        this.plataformaAtiva = new Spotify();
        this.totalReproducoes = 0;
    }

    public static GerenciadorPlataforma getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorPlataforma();
        }
        return instancia;
    }

    public PlataformaImplementacao getPlataformaAtiva() {
        return plataformaAtiva;
    }

    public void setPlataformaAtiva(PlataformaImplementacao plataforma) {
        this.plataformaAtiva = plataforma;
    }

    public void registrarReproducao() {
        totalReproducoes++;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public void resetarContador() {
        totalReproducoes = 0;
    }

    static void resetarInstancia() {
        instancia = null;
    }
}
