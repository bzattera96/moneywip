package org.ada.moneywip.dto;

public class MovimientosAhorroDTO {

    private Integer id;
    private String fecha;
    private double monto;
    private String persona;
    private Integer objetivo;

    public MovimientosAhorroDTO(String fecha, double monto, String persona, Integer objetivo) {
        this.fecha = fecha;
        this.monto = monto;
        this.persona = persona;
        this.objetivo = objetivo;
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

    public String getPersona() {
        return persona;
    }

    public Integer getObjetivo() {
        return objetivo;
    }
}
