package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Carrera {

	@Id @GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "carrera")
	private List<Carrera_Estudiante> estudiantes;

	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
		this.estudiantes = new ArrayList<>();
	}
	
	public Carrera() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Carrera_Estudiante> getEstudiantes() {
		return new ArrayList<>(this.estudiantes);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
	}
	
	
}