package ar.edu.unahur.obj2.wtoj.planes;

import ar.edu.unahur.obj2.wtoj.contenido.*;
import ar.edu.unahur.obj2.wtoj.usuario.Usuario;

import java.util.List;

/*EN la interfaz no se hereda, sino quu se implement la interfaz que vamos a utilizar, usando la palabra reservada implements*/
public class PlanBasico implements Planeable {
    private Integer limite;
    private Double costoFijo = 5.0;

    //Constructores
    public PlanBasico(Integer limite, Double costoBase) {
        this.limite = limite;
        this.costoFijo = costoBase;
    }

    public PlanBasico(Integer limite) {
        this.limite = limite;
    }

    //Getters
    public Integer getLimite() {
        return limite;
    }

    public Double getCostoFijo() {
        return costoFijo;
    }

    //Setters
    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public void setCostoFijo(Double costoFijo) {
        this.costoFijo = costoFijo;
    }

    @Override
    public Double costoPlan(Usuario usuario) {
        List <Contenido> contenido = usuario.getContenidosVistos();
        if (this.limite >= contenido.size()) {
            return costoFijo;
        } else {
            List <Contenido> excedentes = contenido.subList(this.limite, contenido.size());
            return costoFijo + excedentes.stream().mapToDouble(e -> e.costo()).sum();
        }
    }
}
