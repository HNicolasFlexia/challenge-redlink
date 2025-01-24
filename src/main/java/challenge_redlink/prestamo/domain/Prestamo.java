package challenge_redlink.prestamo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_prestamo")
    private Long id;
    private Long monto;
    private String usuariodni;
    private boolean prestamoVisualizado;
    private LocalDateTime fechaVisualizacion;

    public Prestamo(){}

    public Prestamo(Long monto, String usuariodni){
        this. monto = monto;
        this.usuariodni = usuariodni;
        this.prestamoVisualizado = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isPrestamoVisualizado() {
        return prestamoVisualizado;
    }

    public void setPrestamoVisualizado(boolean prestamoVisualizado) {
        this.prestamoVisualizado = prestamoVisualizado;
    }

    public LocalDateTime getFechaVisualizacion() {
        return fechaVisualizacion;
    }

    public void setFechaVisualizacion(LocalDateTime fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }

    public void prestamoVisualizado(LocalDateTime fechaVisualizacion){
        this.fechaVisualizacion = fechaVisualizacion;
        this.prestamoVisualizado = true;
    }
}
