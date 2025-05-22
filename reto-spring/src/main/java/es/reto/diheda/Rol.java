package es.reto.diheda;

import java.util.Objects;

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
    @Column(name = "name", nullable = false)
    private String name;


    public Rol() {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rol)) {
            return false;
        }
        Rol rol = (Rol) o;
        return id == rol.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, name);
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
    

}
