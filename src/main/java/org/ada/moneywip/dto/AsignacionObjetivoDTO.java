package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class AsignacionObjetivoDTO {

    private Integer id;
    private Boolean activo;
    @JsonAlias("id_persona")
    private String idPersona;
    @JsonAlias("id_objetivo")
    private Integer idObjetivo;


    public AsignacionObjetivoDTO(Integer id, Boolean activo, String idPersona, Integer idObjetivo) {
        this.id = id;
        this.activo = activo;
        this.idPersona = idPersona;
        this.idObjetivo = idObjetivo;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public Integer getIdObjetivo() {
        return idObjetivo;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
