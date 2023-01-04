package org.ada.moneywip.entity;

import javax.persistence.*;

@Entity
//cuando lo convierto en entidad, debo asignar una primary key

@Table (name = "asignacion_objetivo")


//CREATE TABLE IF NOT EXISTS asignacion_objetivo (
//id INT AUTO_INCREMENT NOT NULL,
//activo BOOLEAN NOT NULL,
//id_persona VARCHAR(8) NOT NULL,
//id_objetivo INT NOT NULL,


public class AsignacionObjetivo {


    @Id  //Id corresponde a la primary key de mySQL, no puede ser NULL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private Boolean activo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "id_objetivo", nullable = false)
    private Objetivo objetivo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "id_persona", nullable = false)
    private Persona persona;

    //constructores
    public AsignacionObjetivo() {
    }

    public AsignacionObjetivo(Integer id, Boolean activo, Objetivo objetivo, Persona persona) {
        this.id = id;
        this.activo = activo;
        this.objetivo = objetivo;
        this.persona = persona;
    }

    //getters

    public Integer getId() {
        return id;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public Persona getPersona() {
        return persona;
    }
}

