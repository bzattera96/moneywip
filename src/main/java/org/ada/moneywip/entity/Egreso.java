
package org.ada.moneywip.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "egresos")
public class Egreso {

    private static final DateTimeFormatter DATE_TIME_FORMATER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

    @Column (nullable = false)
    private LocalDate fecha;

    @Column (nullable = false)
    private Double monto;

    /*@ManyToOne(fetch = FetchType.EAGER) //FORANEA OTRA CLASE
    //1 siempre cargo persona asociada
    @JoinColumn (name = "person_id", nullable = false) //atributo es la columna representa relación, si es mandatoria
    private Person person;*/

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn (name= "tipo_egreso", nullable = false)
    private TipoEgreso tipoEgreso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_persona" ,nullable = false)
    private Persona persona;

    public Egreso() {
    }

    public Egreso(Integer id, LocalDate fecha, Double monto, TipoEgreso tipoEgreso, Persona persona) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoEgreso = tipoEgreso;
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

    public Integer getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public TipoEgreso getTipoEgreso() {
        return tipoEgreso;
    }

    public Persona getPersona() {
        return persona;
    }
}
