package ar.edu.unahur.obj2.wtoj.contenido;

//PAtron Singletlon para que yo haya uno

public class IDRA {
    //Atributos
    /*
     * Es una instancia privada y unica, mas adelante generar el getter.
     * Con el patron singleton y static transformamos al atributo de instancia en un atributo de clase,
     * Entonces podemos usar los metodos a traves de la clase y no de uan instancia: IDRA.getInstance()
     * Algo malo de esto es que el objeto ya esta guardado en memoria, y si es muy grande ocupa mucho espacio
    */
    private static IDRA instance = new IDRA();
    private Double canon = 0.5;

    //Constructor: Se debe ocultar el constructor para el patron singleton
    private IDRA() {
    }

    //getter de la unica instancia paa que los atributos sean privados
    public static IDRA getInstance() {
        return instance;
    }

    //getter y setter del valor del IDRA
    public Double getCanon() {
        return canon;
    }
    public void setCanon(Double canon) {
        this.canon = canon;
    }
}
