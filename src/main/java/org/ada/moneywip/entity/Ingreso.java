package org.ada.moneywip.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity

@Table (name = "ingresos")

public class Ingreso {

    private static final DateTimeFormatter DATE_TIME_FORMATER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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

    public Ingreso( LocalDate fecha, Double monto, TipoIngreso tipoIngreso, Persona persona) {
        this.fecha = fecha;
        this.monto = monto;
        this.tipoIngreso = tipoIngreso;
        this.persona = persona;
    }

    public void modifyAttributeValue (String key, Object value){
            switch (key){
                case "fecha" :
                    this.fecha= LocalDate.parse((String) value, DATE_TIME_FORMATER);
                    break;
                case "monto":
                    this.monto = (double) value;
                    break;
            }
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