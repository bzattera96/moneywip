package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.ada.moneywip.entity.Ingreso;

import java.util.List;

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

    public void setId(Integer id) {
        this.id = id;
    }
}