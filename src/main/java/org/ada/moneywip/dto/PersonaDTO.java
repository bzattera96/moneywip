package org.ada.moneywip.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PersonaDTO {
    private String dni;
    private String nombre;
    private String apellido;
    private String genero;
    private String celular;
    private int edad;
    @JsonAlias("recibe_ingresos")
    private boolean recibeIngresos;
    private boolean estudia;

    public PersonaDTO(String dni, String nombre, String apellido, String genero, String celular, int edad, boolean recibeIngresos, boolean estudia) {
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
}