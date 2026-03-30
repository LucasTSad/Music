package streaming.implementacao;

public class AppleMusic implements PlataformaImplementacao {

    @Override
    public String getNome() {
        return "Apple Music";
    }

    @Override
    public double calcularCustoExtra(double duracaoMinutos) {
        // Apple Music não cobra custo extra (plano mensal fixo)
        return 0.0;
    }

    @Override
    public String processarReproducao(String tipoReproducao, String titulo) {
        return "[Apple Music] " + tipoReproducao + " de \"" + titulo + "\" sincronizada via iCloud.";
    }
}
