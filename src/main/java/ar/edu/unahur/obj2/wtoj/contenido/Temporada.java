package ar.edu.unahur.obj2.wtoj.contenido;

import java.util.List;
import java.util.ArrayList;

public class Temporada {
    private final List <Episodio> episodios;
    private final Integer numero;
    
    public Temporada(Integer nroTemporada, List <Episodio> episodiosIniciales){
        this.numero = nroTemporada;
        this.episodios = episodiosIniciales;
    }

    public Temporada(Integer nroTemporada){
        this.numero = nroTemporada;
        this.episodios = new ArrayList<>();
    }

    public List<Episodio> getEpisodios() {
        return new ArrayList<>(episodios);
    }

    public Integer getNumero() {
        return numero;
    }

    protected Double getCostoTotalEpisodios() {
        return episodios.stream().mapToDouble(e -> e.getCostoBase()).sum();
    }

    public void agregarEpisodio(Episodio episodioNueva) {
        this.episodios.add(episodioNueva);
    }

    public void eliminarEpisodio(Episodio episodioAEliminar) {
        this.episodios.remove(episodioAEliminar);
    }
}
