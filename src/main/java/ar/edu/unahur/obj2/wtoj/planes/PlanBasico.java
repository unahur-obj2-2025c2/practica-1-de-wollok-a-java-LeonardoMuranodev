package ar.edu.unahur.obj2.wtoj.planes;

/*EN la interfaz no se hereda, sino quu se implement la interfaz que vamos a utilizar, usando la palabra reservada implements*/
public class PlanBasico implements Planeable {
    private Integer limite;

    public PlanBasico(Integer limite) {
        this.limite = limite;
    }

    @Override
    public Double costoPlan(Usuario usuario) {
        return null; //TODO: falta implementar
    }
}
