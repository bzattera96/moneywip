package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AsigancionObjetivoDTO {

    private Integer id;
    private boolean activo;
    @JsonAlias("id_persona")
    private String idPersona;
    @JsonAlias("id_objetivo")
    private Integer idObjetivo;
    //preguntar por el idObj.


    public AsigancionObjetivoDTO(boolean activo, String idPersona, Integer idObjetivo) {
        this.activo = activo;
        this.idPersona = idPersona;
        this.idObjetivo = idObjetivo;
    }

    public boolean getActivo() {
        return activo;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public int getIdObjetivo() {
        return idObjetivo;
    }
}
