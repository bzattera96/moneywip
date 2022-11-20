package org.ada.moneywip.entity;

import javax.persistence.*;
import java.time.LocalDate;

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
    private double monto;

    @Column(nullable = false)
    private boolean activo;

    @OneToMany(mappedBy = "idObjetivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AsignacionObjetivo asignacionObjetivo;

    @OneToMany(mappedBy = "idObjetivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MovimientosAhorro movimientosAhorro;

    public Objetivo() {
    }

    public Objetivo(Integer id, String objetivo, LocalDate fechaObj, double monto, boolean activo, AsignacionObjetivo asignacionObjetivo, MovimientosAhorro movimientosAhorro) {
        this.id = id;
        this.objetivo = objetivo;
        this.fechaObj = fechaObj;
        this.monto = monto;
        this.activo = activo;
        this.asignacionObjetivo = asignacionObjetivo;
        this.movimientosAhorro = movimientosAhorro;
    }

    public int getId() {
        return id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public LocalDate getFechaObj() {
        return fechaObj;
    }

    public double getMonto() {
        return monto;
    }

    public boolean getActivo() {
        return activo;
    }

    public AsignacionObjetivo getAsignacionObjetivo() {
        return asignacionObjetivo;
    }

    public MovimientosAhorro getMovimientosAhorro() {
        return movimientosAhorro;
    }
}