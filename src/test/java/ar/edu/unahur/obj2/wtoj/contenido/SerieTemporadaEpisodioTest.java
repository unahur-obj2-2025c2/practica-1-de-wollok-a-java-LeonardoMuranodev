package ar.edu.unahur.obj2.wtoj.contenido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SerieTemporadaEpisodioTest {
    Episodio epi1 = new Episodio("Capitulo 1", 100.0, 1);
    Episodio epi2 = new Episodio("Capitulo 2", 200.0, 2);
    Episodio epi10 = new Episodio("Capitulo 10", 400.0, 3);
    Episodio epi11 = new Episodio("Capitulo 11", 600.0, 4);
    Episodio epi20 = new Episodio("Capitulo 20", 0.0, 20);
    Episodio epi21 = new Episodio("Capitulo 21", 0.0, 21);

    Temporada temp1 = new Temporada(1, List.of(epi1, epi2));
    Temporada temp2 = new Temporada(2, List.of(epi10, epi11));
    Temporada temp3 = new Temporada(2, List.of(epi20, epi21));

    @Test
    void testSerieCostoYTamanio() {
        List<Temporada> temporadas = new ArrayList<>();
        temporadas.add(temp1);

        Serie serie = new Serie("Breaking Bad", 200.0, temporadas);
        serie.agregarTemporada(temp2);

        assertEquals(2, serie.getTemporadas().size());
        assertEquals(325, serie.doCosto());
        assertEquals(525, serie.costo());
    }

    @Test
    void testSerieSinEpisodios() {
        Serie serie = new Serie("Breaking Bad", 200.0);
        serie.agregarTemporada(temp1);
        serie.eliminarTemporada(temp1);

        Error ex = assertThrows(Error.class, () -> {
            serie.doCosto();
        });

        assertEquals("La serie todavia no tiene episodios", ex.getMessage());
    }

    @Test
    void testSerieConEpisodiosValor0() {
        Serie serie = new Serie("Breaking Bad", 200.0);
        serie.agregarTemporada(temp3);

        Error ex = assertThrows(Error.class, () -> {
            serie.doCosto();
        });

        assertEquals("La suma total de los episodios es cero, revisalo", ex.getMessage());
    }

    @Test
    void testTemporadaAgregarYEliminarEpisodio() {
        Temporada temp = new Temporada(1);
        temp.agregarEpisodio(epi1);
        temp.agregarEpisodio(epi2);
        temp.eliminarEpisodio(epi2);
    
        assertEquals(1, temp.getEpisodios().size());
    }

    @Test
    void testNroTemporada() {
        Temporada temp = new Temporada(10);
        assertEquals(10, temp.getNumero());
    }

    @Test
    void testNroEpisodioYDoCosto0() {
        assertEquals(1, epi1.getNroEpisodio());
        assertEquals(2, epi2.getNroEpisodio());
        assertEquals(0.00, epi1.doCosto());
        assertEquals(0.00, epi2.doCosto());
    }
}
