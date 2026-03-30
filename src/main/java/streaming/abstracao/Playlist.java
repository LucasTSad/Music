package streaming.abstracao;

import streaming.implementacao.PlataformaImplementacao;

public class Playlist extends Reproducao {

    private String nome;
    private int quantidadeMusicas;
    private double duracaoTotalMinutos;
    private static final double DESCONTO_PLAYLIST = 0.8;

    public Playlist(PlataformaImplementacao plataforma, String nome, int quantidadeMusicas, double duracaoTotalMinutos) {
        super(plataforma);
        this.nome = nome;
        this.quantidadeMusicas = quantidadeMusicas;
        this.duracaoTotalMinutos = duracaoTotalMinutos;
    }

    @Override
    public void reproduzir(String titulo) {
        System.out.println(plataforma.processarReproducao("Reproducao de playlist", titulo));
    }

    @Override
    public void pausar(String titulo) {
        System.out.println(plataforma.processarReproducao("Pausa de playlist", titulo));
    }

    public void embaralhar() {
        double custoEmbaralhar = plataforma.calcularCustoExtra(duracaoTotalMinutos) * DESCONTO_PLAYLIST;
        System.out.println(plataforma.processarReproducao("Modo aleatório da playlist", nome));
        System.out.println("Custo do modo aleatório: R$ " + custoEmbaralhar);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Tipo      : Playlist");
        System.out.println("Plataforma: " + plataforma.getNome());
        System.out.println("Nome      : " + nome);
        System.out.println("Musicas   : " + quantidadeMusicas);
        System.out.println("Duracao   : " + duracaoTotalMinutos + " min");
        System.out.println("Custo ext.: R$ " + plataforma.calcularCustoExtra(duracaoTotalMinutos));
        System.out.println();
    }

    public double getDuracaoTotal() { return duracaoTotalMinutos; }

    public double getCustoExtra() { return plataforma.calcularCustoExtra(duracaoTotalMinutos); }
}
