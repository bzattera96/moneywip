
package org.ada.moneywip.entity;

import javax.persistence.*;
import java.util.List;

@Entity
 // CUANDO LO CONVIERTO EN ENTIDAD TENGO QUE ASIGNAR UNA PRIMARY KEY
@Table(name = "tipo_egreso")

public class TipoEgreso {
/*
CREATE TABLE IF NOT EXISTS tipo_egreso (
id INT AUTO_INCREMENT NOT NULL,
tipo_egreso VARCHAR(50) NOT NULL,
PRIMARY KEY(id)
);*/
    @Id // id corresponde a pk de mysql,no puede ser null
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "tipo_egreso" ,nullable = false)
    private String tipoEgreso;


    @OneToMany(mappedBy = "tipoEgreso", fetch = FetchType.LAZY, cascade = CascadeType.ALL) //ES FORANEADA
    //1 define la relación, con atributos + el campo que en la otra tabla va a mapear la relación
    //2 lazy: no los voy a cargar, eager: sí cada vez que consulto la persona
    //3 all (todo desde comienzo), persist (cada actualización), merge, remove (se deberían remover si remuevo persona), refresh, detach →
    private List<Egreso> egresos;

    public TipoEgreso() {
    }

    public TipoEgreso(Integer id, String tipoEgreso) {
        this.id = id;
        this.tipoEgreso = tipoEgreso;
        this.egresos = egresos;
    }

    public void modifyAttributeValue(String key, Object value) {
        switch (key) {
            case "tipo_egreso":
                this.tipoEgreso = (String) value; //(String) me lo vuelve un string, casteo
                break;

        }
    }

    public Integer getId() {
        return id;
    }

    public String getTipoEgreso() {
        return tipoEgreso;
    }

    public List<Egreso> getEgresos() {
        return egresos;
    }
}