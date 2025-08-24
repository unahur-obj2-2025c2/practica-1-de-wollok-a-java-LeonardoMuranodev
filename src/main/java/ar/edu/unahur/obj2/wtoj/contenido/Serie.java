package ar.edu.unahur.obj2.wtoj.contenido;

import java.util.List;
import java.util.ArrayList;

public class Serie extends Contenido {
    private final List <Temporada> temporadas;

    public Serie (String titulo, Double costoBase, List <Temporada> temporadasIniciales) {
        super(titulo, costoBase);
        this.temporadas = temporadasIniciales;
    }

    //COnstructor por si no se ponen temporadas
    public Serie (String titulo, Double costoBase) {
        super(titulo, costoBase);
        this.temporadas = new ArrayList<>();
    }

    //Promedio de todos sus episodios
    @Override
    protected Double doCosto() {
        Integer nroEpisodios = temporadas.stream().mapToInt(t -> t.getEpisodios().size()).sum();
        Double sumaTotalEpisodios = temporadas.stream().mapToDouble(t -> t.getCostoTotalEpisodios()).sum();
        if (nroEpisodios == 0) {
            throw new Error("La serie todavia no tiene episodios");
        } else if (sumaTotalEpisodios == 0) {
            throw new Error("La suma total de los episodios es cero, revisalo");
        } else {
            return sumaTotalEpisodios / nroEpisodios;
        }
    }

    //Getter de temporada
    public List<Temporada> getTemporadas() {
        return new ArrayList<>(temporadas);
    }

    //Agregar o eliminar temporadas
    public void agregarTemporada(Temporada temporadaNueva) {
        this.temporadas.add(temporadaNueva);
    }

    public void eliminarTemporada(Temporada temporadaAEliminar) {
        this.temporadas.remove(temporadaAEliminar);
    }
}
