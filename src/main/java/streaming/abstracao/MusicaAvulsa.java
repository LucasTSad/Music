package streaming.abstracao;

import streaming.implementacao.PlataformaImplementacao;

public class MusicaAvulsa extends Reproducao {

    private String titulo;
    private String artista;
    private double duracaoMinutos;

    public MusicaAvulsa(PlataformaImplementacao plataforma, String titulo, String artista, double duracaoMinutos) {
        super(plataforma);
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public void reproduzir(String titulo) {
        System.out.println(plataforma.processarReproducao("Reproducao de musica", titulo));
    }

    @Override
    public void pausar(String titulo) {
        System.out.println(plataforma.processarReproducao("Pausa de musica", titulo));
    }

    @Override
    public void exibirInfo() {
        System.out.println("Tipo      : Musica Avulsa");
        System.out.println("Plataforma: " + plataforma.getNome());
        System.out.println("Titulo    : " + titulo);
        System.out.println("Artista   : " + artista);
        System.out.println("Duracao   : " + duracaoMinutos + " min");
        System.out.println("Custo ext.: R$ " + plataforma.calcularCustoExtra(duracaoMinutos));
        System.out.println();
    }

    public double getDuracao() { return duracaoMinutos; }

    public double getCustoExtra() { return plataforma.calcularCustoExtra(duracaoMinutos); }
}
