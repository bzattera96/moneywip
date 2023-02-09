package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class IngresoDTO {

    private Integer id;
    private String fecha; //el formato va en el service, si no seria LocalDate
    private Double monto;
    @JsonAlias("tipo_ingreso")
    private Integer tipoIngreso;
    @JsonAlias("persona_dni")
    private String personaDni; // como pasar tipo ingreso y dni en service para entidad


    public IngresoDTO(Integer id, String fecha, Double monto, Integer tipoIngreso, String personaDni) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoIngreso = tipoIngreso;
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

    public Integer getTipoIngreso() {
        return tipoIngreso;
    }

    public String getPersonaDni() {
        return personaDni;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
