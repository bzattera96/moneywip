package org.ada.moneywip.entity;

import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "tipo_ingreso")

public class TipoIngreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_ingreso", nullable = false)
    private String tipoIngreso;

    @OneToMany(mappedBy = "tipoIngreso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //private list de tipoingreso List<Ingresos> en onetomany
    private List<Ingreso> ingreso;

    public TipoIngreso() {
    }

    public TipoIngreso(Integer id, String tipoIngreso, List<Ingreso> ingreso) {
        this.id = id;
        this.tipoIngreso = tipoIngreso;
        this.ingreso = ingreso;
    }

    public Integer getId() {
        return id;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public List<Ingreso> getIngreso() {
        return ingreso;
    }


    public void modifyAttributeValue(String key, Object value) {
        switch (key) {
            case "tipo_ingreso":
                this.tipoIngreso = (String) value; //(String) me lo vuelve un string, casteo
                break;

        }
    }
}