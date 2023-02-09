package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MovimientosAhorroDTO {

    private Integer id;
    private String fecha;
    private Double monto;
    @JsonAlias("id_persona")
    private String personaDni;
    @JsonAlias("id_objetivo")
    private Integer objetivo;

    public MovimientosAhorroDTO(Integer id, String fecha, Double monto, String personaDni, Integer objetivo) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.personaDni = personaDni;
        this.objetivo = objetivo;
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

    public String getPersonaDni() {
        return personaDni;
    }

    public Integer getObjetivo() {
        return objetivo;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
