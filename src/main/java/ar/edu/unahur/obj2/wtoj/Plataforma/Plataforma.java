package ar.edu.unahur.obj2.wtoj.Plataforma;

import java.util.List;

import ar.edu.unahur.obj2.wtoj.Usuario.Usuario;
import ar.edu.unahur.obj2.wtoj.contenido.IDRA;

import java.util.ArrayList;

public class Plataforma {
    private List <Usuario> usuarios = new ArrayList<>();
    private static Plataforma instance = new Plataforma();

    private Plataforma() {}

    public static Plataforma getInstance() {
        return instance;
    }

    public Double facturacionMensual() {
        return usuarios.stream().mapToDouble(u -> u.costeMensual()).sum();
    }

    public void limpiarContenidoDeUsuarios() {
        usuarios.stream().forEach(u -> u.limpiarContenido());
    }

    public void agregarUsuarios(Usuario usuarioNuevo) {
        this.usuarios.add(usuarioNuevo);
    }

    public void eliminarUsuario(Usuario usuarioAEliminar) {
        this.usuarios.remove(usuarioAEliminar);
    }
}
