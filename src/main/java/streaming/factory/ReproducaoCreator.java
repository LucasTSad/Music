package streaming.factory;

import streaming.abstracao.Reproducao;

public abstract class ReproducaoCreator {

    public abstract Reproducao criarReproducao();

    public String iniciarReproducao(String titulo) {
        Reproducao reproducao = criarReproducao();
        reproducao.reproduzir(titulo);
        return "Reprodução iniciada via " + getClass().getSimpleName();
    }
}
