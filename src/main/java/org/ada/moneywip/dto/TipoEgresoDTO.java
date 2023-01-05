package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TipoEgresoDTO {

    private Integer id;
    @JsonAlias ("tipo_egreso")
    private String tipoEgreso;

    public TipoEgresoDTO(Integer id, String tipoEgreso) {
        this.id = id;
        this.tipoEgreso = tipoEgreso;
    }

    public Integer getId() {
        return id;
    }

    public String getTipoEgreso() {
        return tipoEgreso;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
