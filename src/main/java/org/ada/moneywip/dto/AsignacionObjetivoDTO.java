package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AsignacionObjetivoDTO {

    private Integer id;
    private boolean activo;
    @JsonAlias("id_persona")
    private String idPersona;
    @JsonAlias("id_objetivo")
    private Integer idObjetivo;


    public AsignacionObjetivoDTO(boolean activo) {
        this.activo = activo;

    }

    public Integer getId() {
        return id;
    }

    public boolean getActivo() {

        return activo;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public Integer getIdObjetivo() {
        return idObjetivo;
    }
}
