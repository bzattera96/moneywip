package org.ada.moneywip.dto;

public class ObjetivoDTO {
    private Integer id;
    private String objetivo;
    private String fechaObj;
    private double monto;
    private boolean activo;

    public ObjetivoDTO(String objetivo, String fechaObj, double monto, boolean activo) {
        this.objetivo = objetivo;
        this.fechaObj = fechaObj;
        this.monto = monto;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getFechaObj() {
        return fechaObj;
    }

    public double getMonto() {
        return monto;
    }

    public boolean getActivo() {
        return activo;
    }
}