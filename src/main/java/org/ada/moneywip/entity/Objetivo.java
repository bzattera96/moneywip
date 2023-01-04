package org.ada.moneywip.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity

@Table(name = "objetivo")

public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String objetivo;

    @Column(name = "fecha_obj", nullable = false)
    private LocalDate fechaObj;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private Boolean activo;

    @OneToMany(mappedBy = "objetivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AsignacionObjetivo> asignacionObjetivo;

    @OneToMany(mappedBy = "objetivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovimientosAhorro> movimientosAhorro;

    public Objetivo() {
    }

    public Objetivo(Integer id, String objetivo, LocalDate fechaObj, Double monto, Boolean activo, List<AsignacionObjetivo> asignacionObjetivo, List<MovimientosAhorro> movimientosAhorro) {
        this.id = id;
        this.objetivo = objetivo;
        this.fechaObj = fechaObj;
        this.monto = monto;
        this.activo = activo;
        this.asignacionObjetivo = asignacionObjetivo;
        this.movimientosAhorro = movimientosAhorro;
    }

    public Integer getId() {
        return id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public LocalDate getFechaObj() {
        return fechaObj;
    }

    public Double getMonto() {
        return monto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public List<AsignacionObjetivo> getAsignacionObjetivo() {
        return asignacionObjetivo;
    }

    public List<MovimientosAhorro> getMovimientosAhorro() {
        return movimientosAhorro;
    }
}