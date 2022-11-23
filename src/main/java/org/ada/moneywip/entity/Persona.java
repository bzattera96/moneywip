package org.ada.moneywip.entity;

import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "persona")
public class Persona {

    @Id
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column
    private String genero;

    @Column
    private String celular;

    @Column(nullable = false)
    private int edad;

    @Column(name = "recibe_ingresos", nullable = false)
    private boolean recibeIngresos;

    @Column(nullable = false)
    private boolean estudia;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AsignacionObjetivo> asignacionObjetivo;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovimientosAhorro> movimientosAhorro;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ingreso> ingreso;

    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Egreso> egreso;

    public Persona() {
    }

    public Persona(String dni, String nombre, String apellido, String genero, String celular, int edad, boolean recibeIngresos, boolean estudia, List<AsignacionObjetivo> asignacionObjetivo, List<MovimientosAhorro> movimientosAhorro, List<Ingreso> ingreso, List<Egreso> egreso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.celular = celular;
        this.edad = edad;
        this.recibeIngresos = recibeIngresos;
        this.estudia = estudia;
        this.asignacionObjetivo = asignacionObjetivo;
        this.movimientosAhorro = movimientosAhorro;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public String getCelular() {
        return celular;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isRecibeIngresos() {
        return recibeIngresos;
    }

    public boolean isEstudia() {
        return estudia;
    }

    public List<AsignacionObjetivo> getAsignacionObjetivo() {
        return asignacionObjetivo;
    }

    public List<MovimientosAhorro> getMovimientosAhorro() {
        return movimientosAhorro;
    }

    public List<Ingreso> getIngreso() {
        return ingreso;
    }

    public List<Egreso> getEgreso() {
        return egreso;
    }
}