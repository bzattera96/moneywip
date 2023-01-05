package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class EgresoDTO {

    private String id;
    private String fecha;
    private Double monto;
    @JsonAlias("tipo_egreso")
    private Integer tipoEgreso;
    @JsonAlias("persona_dni")
    private String personaDni;

    public EgresoDTO(String fecha, Double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public Integer getTipoEgreso() {
        return tipoEgreso;
    }

    public String getPersonaDni() {
        return personaDni;
    }

    public void setId(String id) {
        this.id = id;
    }
}
