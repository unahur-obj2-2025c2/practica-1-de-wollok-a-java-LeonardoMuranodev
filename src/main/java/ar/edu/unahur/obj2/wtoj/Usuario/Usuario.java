package ar.edu.unahur.obj2.wtoj.usuario;

import ar.edu.unahur.obj2.wtoj.contenido.*;
import ar.edu.unahur.obj2.wtoj.planes.*;
import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private List <Contenido> contenidosVistos = new ArrayList<>();
    private Planeable planActual;
    
    //Constructor
    public Usuario(Planeable planActual) {
        this.planActual = planActual;
    }

    //Getters
    public List<Contenido> getContenidosVistos() {
        return new ArrayList<>(contenidosVistos);
    }

    public Planeable getPlanActual() {
        return planActual;
    }

    public Double costeMensual() {
        return this.planActual.costoPlan(this);
    }

    //Agregar contenido, limpiar contenido y setter plan
    public void verContenido(Contenido unContenido) {
        this.contenidosVistos.add(unContenido);
    }

    public void limpiarContenido() {
        this.contenidosVistos.clear();
    }

    public void setPlanActual(Planeable planActual) {
        this.planActual = planActual;
    }
}
