package streaming.implementacao;

public class Spotify implements PlataformaImplementacao {

    @Override
    public String getNome() {
        return "Spotify";
    }

    @Override
    public double calcularCustoExtra(double duracaoMinutos) {
        // Spotify cobra R$ 0,10 por minuto em plano gratuito
        return duracaoMinutos * 0.10;
    }

    @Override
    public String processarReproducao(String tipoReproducao, String titulo) {
        return "[Spotify] " + tipoReproducao + " de \"" + titulo + "\" iniciada com streaming adaptativo.";
    }
}
