package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.ada.moneywip.entity.Persona;
import org.ada.moneywip.entity.TipoIngreso;

public class IngresoDTO {

    private Integer id;
    private String fecha; //el formato va en el service, si no seria LocalDate
    private Double monto;
    @JsonAlias("tipo_ingreso")
    private String tipoIngreso;
    @JsonAlias("persona_dni")
    private String personaDni; // como pasar tipo ingreso y dni en service para entidad


    public IngresoDTO(Integer id, String fecha, Double monto) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
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

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public String getPersonaDni() {
        return personaDni;

    }

    public void setId(Integer id) {
        this.id = id;
    }
}
