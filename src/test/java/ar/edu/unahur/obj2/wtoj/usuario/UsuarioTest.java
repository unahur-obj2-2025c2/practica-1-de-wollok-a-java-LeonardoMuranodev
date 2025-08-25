package ar.edu.unahur.obj2.wtoj.usuario;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.Pelicula;

public class UsuarioTest {
    Usuario usuario1 = new Usuario(null);

    Pelicula pelicula = new Pelicula("Matrix", 50.5);

    @Test
    void testVerContenidos() {
        usuario1.verContenido(pelicula);
    }
}
