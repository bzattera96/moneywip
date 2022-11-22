package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TipoIngresoDTO {
    private Integer id;
    @JsonAlias("tipo_ingreso")
    private String tipoIngreso;

    public TipoIngresoDTO(Integer id, String tipoIngreso) {
        this.id = id;
        this.tipoIngreso = tipoIngreso;
    }

    public Integer getId() {
        return id;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }
}