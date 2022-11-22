package org.ada.moneywip.dto;

public class MovimientosAhorroDTO {

    private String id;
    private String fecha;
    private double monto;
    private String persona;
    private String objetivo; // preguntar si ponemos objetivo en dto

    public MovimientosAhorroDTO( String fecha, double monto, String persona, String objetivo) { // agrego id?
        this.fecha = fecha;
        this.monto = monto;
        this.persona = persona;
        this.objetivo = objetivo;
    }

    public String getId() {
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

    public String getObjetivo() {
        return objetivo;
    }
}
