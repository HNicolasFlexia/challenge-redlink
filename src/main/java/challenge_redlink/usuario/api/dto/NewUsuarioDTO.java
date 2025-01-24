package challenge_redlink.usuario.api.dto;

import challenge_redlink.usuario.domain.TipoUsuario;

public class NewUsuarioDTO {
    private String dni;
    private String name;
    private TipoUsuario tipoUsuario;

    public NewUsuarioDTO(){}

    public NewUsuarioDTO(String dni, String name, TipoUsuario tipoUsuario){
        this.dni = dni;
        this.name = name;
        this.tipoUsuario = tipoUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
