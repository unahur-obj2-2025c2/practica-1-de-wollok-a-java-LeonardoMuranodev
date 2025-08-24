package ar.edu.unahur.obj2.wtoj.contenido;

public class Episodio extends Contenido {
    private Integer numero;

    public Episodio(String titulo, Double costoBase, Integer nroEpisodio) {
        super(titulo, costoBase);
        this.numero = nroEpisodio;
    }

    public Integer getNroEpisodio() {
        return numero;
    }

    @Override
    protected Double doCosto() {
        return 0.00;
    }
}
