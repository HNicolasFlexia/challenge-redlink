package challenge_redlink.prestamo.api.dto;

public class OfertaPrestamoDTO {
    private Long monto;
    private String descripcion;

    public OfertaPrestamoDTO(){}

    public OfertaPrestamoDTO(Long monto, String descripcion){
        this.monto = monto;
        this.descripcion =  descripcion;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
