package org.ada.moneywip.dto;

public class MovimientosAhorroDTO {

    private Integer id;
    private String fecha;
    private double monto;
    private String personaDni;
    private Integer objetivo;

    public MovimientosAhorroDTO(String fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public String getPersonaDni() {
        return personaDni;
    }

    public Integer getObjetivo() {
        return objetivo;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
