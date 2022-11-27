package org.ada.moneywip.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public Persona(String dni, String nombre, String apellido, String genero, String celular, int edad, boolean recibeIngresos, boolean estudia) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.celular = celular;
        this.edad = edad;
        this.recibeIngresos = recibeIngresos;
        this.estudia = estudia;
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

    public boolean getRecibeIngresos() {
        return recibeIngresos;
    }

    public boolean getEstudia() {
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

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setRecibeIngresos(boolean recibeIngresos) {
        this.recibeIngresos = recibeIngresos;
    }

    public void setEstudia(boolean estudia) {
        this.estudia = estudia;
    }

    public void setAsignacionObjetivo(List<AsignacionObjetivo> asignacionObjetivo) {
        this.asignacionObjetivo = asignacionObjetivo;
    }

    public void setMovimientosAhorro(List<MovimientosAhorro> movimientosAhorro) {
        this.movimientosAhorro = movimientosAhorro;
    }

    public void setIngreso(List<Ingreso> ingreso) {
        this.ingreso = ingreso;
    }

    public void setEgreso(List<Egreso> egreso) {
        this.egreso = egreso;
    }

    public void modifyAttributeValue(String key, Object value) {
        switch (key) {
            case "nombre":
                this.nombre = (String) value;
                break;
            case "apellido":
                this.apellido = (String) value;
                break;
            case "genero":
                this.genero = (String) value;
                break;
            case "celular":
                this.celular = (String) value;
                break;
            case "edad":
                this.edad = (int) value;
                break;
            case "recibe_ingresos":
                this.recibeIngresos = (boolean) value;
                break;
            case "estudia":
                this.estudia = (boolean) value;
                break;
        }
    }
}