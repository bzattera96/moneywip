
package org.ada.moneywip.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/*CREATE TABLE IF NOT EXISTS movimientos_ahorro (
id INT AUTO_INCREMENT NOT NULL,
fecha DATE NOT NULL,
monto DOUBLE NOT NULL,
id_persona VARCHAR(8) NOT NULL,
id_objetivo INT NOT NULL,
PRIMARY KEY(id),
CONSTRAINT fk_movimientos_ahorro_persona_idx
 FOREIGN KEY (id_persona) REFERENCES persona (dni),
CONSTRAINT fk_movimientos_ahorro_objetivo_idx
 FOREIGN KEY (id_objetivo) REFERENCES objetivo (id)
);*/
@Entity
@Table (name= "movimientos_ahorro")
public class MovimientosAhorro {

    private static final DateTimeFormatter DATE_TIME_FORMATER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column (nullable = false)
    private Double monto;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn (name= "id_persona", nullable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_objetivo" ,nullable = false)
    private Objetivo objetivo;

    public MovimientosAhorro() {
    }

    public MovimientosAhorro(Integer id, LocalDate fecha, Double monto, Persona persona, Objetivo objetivo) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.persona = persona;
        this.objetivo = objetivo;
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

    public Persona getPersona() {
        return persona;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void modifyAttributeValue(String key, Object value) {
        switch (key){
            case "fecha" :
                this.fecha= LocalDate.parse((String) value, DATE_TIME_FORMATER);
                break;
            case "monto":
                this.monto = (double) value;
                break;
            case "persona"  :
                this.persona = (Persona) value;
                break;
            case "objetivo"   :
                this.objetivo =(Objetivo) value;
                break;
        }
    }
}
