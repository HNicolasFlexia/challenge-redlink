package challenge_redlink.usuario.domain;

public enum TipoUsuario {
    EMPLEADO("Empleado"),
    ADMINISTRADOR("Administrador"),
    PRESTADOR("Prestador");

    private String descripcion;

    TipoUsuario(String descripcion) {
        this.descripcion = descripcion;
    }
}
