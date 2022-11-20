package org.ada.moneywip.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity

@Table (name = "ingresos")

public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private LocalDate fecha;

    @Column (nullable = false)
    private Double monto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "tipo_ingreso", nullable = false)
    private TipoIngreso tipoIngreso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "id_persona", nullable = false)
    private Persona persona;


    //constructores

    public Ingreso() {
    }

    public Ingreso(Integer id, LocalDate fecha, Double monto, TipoIngreso tipoIngreso, Persona persona) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoIngreso = tipoIngreso;
        this.persona = persona;
    }

    //getters

    public Integer getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public TipoIngreso getTipoIngreso() {
        return tipoIngreso;
    }

    public Persona getPersona() {
        return persona;
    }
}