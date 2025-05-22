package es.reto.diheda.clases;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    public Rol() {
    }

    public Rol(int id) {
        this.id = id;
    }

    public Rol(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol id(int id) {
        setId(id);
        return this;
    }

    public Rol descripcion(String descripcion) {
        setDescripcion(descripcion);
        return this;
    }

    @Override
    public String toString() {
        return " id=" + getId() +", descripcion=" + getDescripcion();
    }
    
}
