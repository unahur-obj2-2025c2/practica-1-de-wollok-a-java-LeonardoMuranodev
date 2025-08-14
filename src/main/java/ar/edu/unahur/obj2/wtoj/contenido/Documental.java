package ar.edu.unahur.obj2.wtoj.contenido;

public class Documental extends Contenido{
    public Documental (String titulo, Double costo){
        super(titulo, costo);
    }
    
    //Metodo que suma al costo base, el costo base se hereda de Contenido
    @Override
    protected Double doCosto() {
        //Primero debo acceder a la instancia singleton de IDRA, luego accedo al valor de la instancia
        return IDRA.getInstance().getCanon();
    }
}
