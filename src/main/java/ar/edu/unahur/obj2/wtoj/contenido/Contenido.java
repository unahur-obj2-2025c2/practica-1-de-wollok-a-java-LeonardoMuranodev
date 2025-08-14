package ar.edu.unahur.obj2.wtoj.contenido;

public abstract class Contenido {
    //Final permite que sea como una constante, no se puede modificar su valor
    private final String titulo;
    private Double costoBase;

    //Constructor de la clase
    public Contenido(String titulo, Double costoBase) {
        this.titulo = titulo;
        this.costoBase = costoBase;
    }

    //Sintaxis: public + <tipo-de-retorno> + nombre de la funcion
    public String getTitulo() {
        return titulo;
    }

    public Double getCostoBase() {
        return costoBase;
    }

    //Como es un metodo de accion (setter) no devuelve nada, asi que es void(vacio)
    public void setCostoBase(Double costoBase) {
        this.costoBase = costoBase;
    }

    //Template method
    public Double costo() {
        return costoBase + this.doCosto();
    }
    
    //Metodo abstracto que es diferente para cada clase hija para mantener polimorfismo
    protected abstract Double doCosto();
}
