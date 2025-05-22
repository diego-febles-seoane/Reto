package es.reto.diheda;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false)
	private String name;
	
    /**
     * constructor vacio
     */
	public Usuario() {
	}
	
    /**
     * constructor con el nombre
     * @param name
     */
	public Usuario(String name) {
		this.name = name;
	}

	/**
	 * Constructor con id y nombre
	 * @param id
	 * @param name
	 */
	public Usuario(int id, String name) {
		this.id = id;
		this.name = name;
	}

	
    //getters y setters
	public int getId() {
		return id;
	}
	
    public void setId(int id) {
		this.id = id;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + "]";
	}
}