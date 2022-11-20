
package org.ada.moneywip.entity;

import javax.persistence.*;
import java.time.LocalDate;
/*
id INT AUTO_INCREMENT NOT NULL,
fecha DATE NOT NULL,
monto DOUBLE NOT NULL,
tipo_egreso INT NOT NULL,  -- foreign key de tabla tipo de egreso
id_persona VARCHAR(8) NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_egresos_tipo_egreso_idx
   FOREIGN KEY (tipo_egreso) REFERENCES tipo_egreso (id),
CONSTRAINT fk_egresos_persona_idx
   FOREIGN KEY (id_persona) REFERENCES persona (dni)
);*/
@Entity
@Table(name = "egresos")
public class Egreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

    @Column (nullable = false)
    private LocalDate fecha;

    @Column (nullable = false)
    private double monto;




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

    public Egreso(Integer id, LocalDate fecha, double monto, TipoEgreso tipoEgreso, Persona persona) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoEgreso = tipoEgreso;
        this.persona = persona;
    }

    public int getId() {
        return id;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public double getMonto() {
        return monto;
    }

    public TipoEgreso getTipoEgreso() {
        return tipoEgreso;
    }

    public Persona getPersona() {
        return persona;
    }
}
