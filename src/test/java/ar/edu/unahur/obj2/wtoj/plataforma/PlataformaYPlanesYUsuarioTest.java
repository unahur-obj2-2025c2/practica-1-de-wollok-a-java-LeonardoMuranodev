package ar.edu.unahur.obj2.wtoj.plataforma;

import ar.edu.unahur.obj2.wtoj.usuario.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.wtoj.contenido.*;
import ar.edu.unahur.obj2.wtoj.planes.PlanBasico;
import ar.edu.unahur.obj2.wtoj.planes.PlanPremium;


public class PlataformaYPlanesYUsuarioTest {
    //Singleton plataforma
    Plataforma plataforma = Plataforma.getInstance();

    //Planes
    PlanBasico planBasico1 = new PlanBasico(5, 20.0);
    PlanBasico planBasico2 = new PlanBasico(10);
    PlanPremium planPremium = new PlanPremium(35.0);
    
    //Usuarios
    Usuario usuario1 = new Usuario(planBasico1);
    Usuario usuario2 = new Usuario(planBasico2);
    Usuario usuario3 = new Usuario(planPremium);
    List <Usuario> usuarios = List.of(usuario1, usuario2, usuario3);

    //Contenidos
    Contenido elPadrino = new Pelicula("El Padrino", 20.0);
    Contenido elPadrino2 = new Pelicula("El Padrino 2", 30.0);
    Contenido mazerunner = new Pelicula("Maze Runner", 20.0);

    @BeforeEach
    void agregarUsuariosAPlataforma() {
        plataforma.limpiarUsuarios();
        usuarios.forEach(u -> plataforma.agregarUsuario(u));
        usuarios.forEach(u -> u.verContenido(elPadrino));
        usuarios.forEach(u -> u.verContenido(elPadrino2));
    }

    @Test
    void testFacturacionMensual() {
        assertEquals(planBasico1.getCostoFijo() + planBasico2.getCostoFijo() + planPremium.costoPlan(usuario3), plataforma.facturacionMensual());
    }

    @Test
    void testLimitesPlanBasicoYExcedente() {
        planBasico2.setLimite(2);
        usuario2.verContenido(mazerunner);
        assertEquals(2, planBasico2.getLimite());
        assertEquals(25, usuario2.costeMensual());
    }

    @Test
    void testCostoFijoPlanBasico() {
        planBasico2.setCostoFijo(20.0);
        assertEquals(20.0, planBasico2.getCostoFijo());
    }

    @Test
    void testEliminarContenidoATodosLosUsuarios() {
        plataforma.limpiarContenidoDeUsuarios();
        Integer totalVistosEnPlataforma = plataforma.getUsuarios().stream().mapToInt(u -> u.getContenidosVistos().size()).sum();
        assertEquals(0, totalVistosEnPlataforma);
    }

    @Test
    void eliminarUnUsuarioDePlataforma() {
        plataforma.eliminarUsuario(usuario1);
        assertEquals(2, plataforma.getUsuarios().size());
    }

    @Test
    void cambiarPlanActualDeUsuarioYVerificar() {
        usuario1.setPlanActual(planPremium);
        assertEquals(planPremium, usuario1.getPlanActual());
    }
}
