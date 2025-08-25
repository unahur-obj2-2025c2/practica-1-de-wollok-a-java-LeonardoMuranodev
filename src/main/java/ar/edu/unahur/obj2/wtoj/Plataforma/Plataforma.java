package ar.edu.unahur.obj2.wtoj.plataforma;

import java.util.List;

import ar.edu.unahur.obj2.wtoj.contenido.IDRA;
import ar.edu.unahur.obj2.wtoj.usuario.Usuario;

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

    public void agregarUsuario(Usuario usuarioNuevo) {
        this.usuarios.add(usuarioNuevo);
    }

    public void eliminarUsuario(Usuario usuarioAEliminar) {
        this.usuarios.remove(usuarioAEliminar);
    }

    public void limpiarUsuarios() {
        this.usuarios.clear();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
