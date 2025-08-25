package ar.edu.unahur.obj2.wtoj.contenido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.unahur.obj2.wtoj.contenido.*;
import org.junit.jupiter.api.Test;

//Maven -> proyecto -> lyfecycle -> test
public class ContenidoTest {

    @Test
    void dadaUnaPelicula_SeCalculaElCostoYTitulo() {
        Pelicula pelicula = new Pelicula("Matrix", 50.5);
        pelicula.setCostoBase(55.0);
        assertEquals(55.0, pelicula.costo());
        assertEquals("Matrix", pelicula.getTitulo());
    }

    @Test
    void dadoUnDocumental_SeCalculaElCostoYTitulo() {
        Contenido documental = new Documental("Segunda Guerra Mundial", 10.8);
        IDRA idra = IDRA.getInstance();
        idra.setCanon(1.0);
        assertEquals(10.8, documental.getCostoBase());
        assertEquals(11.8, documental.costo());
        assertEquals("Segunda Guerra Mundial", documental.getTitulo());
    }
}
