package ar.edu.unahur.obj2.wtoj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.Contenido;
import ar.edu.unahur.obj2.wtoj.contenido.Pelicula;
import ar.edu.unahur.obj2.wtoj.contenido.Documental;

//Maven -> proyecto -> lyfecycle -> test
public class PlataformaTest {

    @Test
    void dadaUnaPelicula_SeCalculaElCosto() {
        Pelicula pelicula = new Pelicula("Matriz", 50.5);
        assertEquals(50.5, pelicula.costo());
    }

    @Test
    void dadoUnDocumental_SeCalculaElCosto() {
        Contenido documental = new Documental("Segunda Guerra Mundial", 10.8);
        assertEquals(11.3, documental.costo());
    }
}
