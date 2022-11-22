package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class IngresoDTO {

    private Integer id;
    private String fecha; //el formato va en el service, si no seria LocalDate
    private Double monto;
    @JsonAlias("tipo_ingreso")
    private String tipoIngreso;

    public IngresoDTO(String fecha, Double monto, String tipoIngreso) {
        this.fecha = fecha;
        this.monto = monto;
        this.tipoIngreso = tipoIngreso;
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
}
