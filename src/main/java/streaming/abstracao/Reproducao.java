package streaming.abstracao;

import streaming.implementacao.PlataformaImplementacao;

public abstract class Reproducao {

    protected PlataformaImplementacao plataforma;

    public Reproducao(PlataformaImplementacao plataforma) {
        this.plataforma = plataforma;
    }

    public abstract void reproduzir(String titulo);
    public abstract void pausar(String titulo);
    public abstract void exibirInfo();
}
