package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TipoEgresoDTO {

    private String id;
    @JsonAlias ("tipo_egreso")
    private String tipoEgreso;

    public TipoEgresoDTO(String id, String tipoEgreso) {
        this.id = id;
        this.tipoEgreso = tipoEgreso;
    }

    public String getId() {
        return id;
    }

    public String getTipoEgreso() {
        return tipoEgreso;
    }
}
