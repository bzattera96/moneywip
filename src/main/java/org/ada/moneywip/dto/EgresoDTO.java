package org.ada.moneywip.dto;

public class EgresoDTO {

    private String id;
    private String fecha;
    private double monto;

    public EgresoDTO(String fecha, double monto) { // agrego el id?
        this.fecha = fecha;
        this.monto = monto;
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
}
