package ar.edu.unahur.obj2.wtoj.planes;

import java.util.List;

import ar.edu.unahur.obj2.wtoj.Usuario.Usuario;

import java.util.ArrayList;

public class PlanFamiliar extends PlanBasico{
    private List <Usuario> usuarios;

    public PlanFamiliar(Integer limite, Double costoBase, List<Usuario> usuarios) {
        super(limite, costoBase);
        this.usuarios = usuarios;
    }

    @Override
    public Double costoPlan(Usuario usuario) {
        return usuarios.stream().mapToDouble(u -> this.costoTotal(u) * 0.85).sum();
    }

    public void agregarFamiliar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void quitarFamiliar(Usuario usuario) {
        usuarios.remove(usuario);
    }
}
