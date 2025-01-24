package challenge_redlink.prestamo.api.dto;

public class NewPrestamoDTO {
    private Long monto;
    private String usuariodni;

    public NewPrestamoDTO(){}

    public NewPrestamoDTO(Long monto, String usuariodni){
        this.monto = monto;
        this.usuariodni = usuariodni;
    }

    public Long getMonto() {

        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public String getUsuariodni() {
        return usuariodni;
    }

    public void setUsuariodni(String usuariodni) {
        this.usuariodni = usuariodni;
    }
}
