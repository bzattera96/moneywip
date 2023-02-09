package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class EgresoDTO {

    private Integer id;
    private String fecha;
    private Double monto;
    @JsonAlias("tipo_egreso")
    private Integer tipoEgreso;
    @JsonAlias("persona_dni")
    private String personaDni;

    public EgresoDTO(Integer id, String fecha, Double monto, Integer tipoEgreso, String personaDni) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoEgreso = tipoEgreso;
        this.personaDni = personaDni;
    }

    public Integer getId() {
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

    public void setId(Integer id) {
        this.id = id;
    }
}
