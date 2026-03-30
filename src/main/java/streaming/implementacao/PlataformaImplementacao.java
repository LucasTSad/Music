package streaming.implementacao;

public interface PlataformaImplementacao {
    String getNome();
    double calcularCustoExtra(double duracaoMinutos);
    String processarReproducao(String tipoReproducao, String titulo);    
}      

