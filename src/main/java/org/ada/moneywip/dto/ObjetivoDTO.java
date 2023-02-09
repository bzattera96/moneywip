package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ObjetivoDTO {
    private Integer id;
    private String objetivo;
    @JsonAlias("fecha_obj")
    private String fechaObj;
    private Double monto;
    private Boolean activo;

    public ObjetivoDTO(String objetivo, String fechaObj, Double monto, Boolean activo) {
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

    public Double getMonto() {
        return monto;
    }

    public Boolean getActivo() {
        return activo;
    }
}