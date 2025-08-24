package ar.edu.unahur.obj2.wtoj.planes;

import ar.edu.unahur.obj2.wtoj.Usuario.Usuario;

public class PlanPremium  implements Planeable {
    private Double costoBase;

    public PlanPremium(Double costoBase) {
        this.costoBase = costoBase;
    }

    @Override
    public Double costoPlan(Usuario usuario) {
        return costoBase;
    }
}
