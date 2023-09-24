package dtos;

import java.util.ArrayList;
import java.util.List;

import entidades.Estudiante;

public class EstudianteDto {

	private int dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String genero;
	private String ciudad;
	private int numeroLibreta;
	private ArrayList<Carrera_EstudianteDto> carreras;
	
	
	
	public EstudianteDto(int dni, String nombre, String apellido, int edad, String genero, String ciudad,
			int numeroLibreta) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.numeroLibreta = numeroLibreta;
		this.carreras = new ArrayList<>();
	}

	public EstudianteDto(Estudiante e) {
		super();
		this.dni = e.getDni();
		this.nombre = e.getNombre();
		this.apellido = e.getApellido();
		this.edad = e.getEdad();
		this.genero = e.getGenero();
		this.ciudad = e.getCiudad();
		this.numeroLibreta = e.getNumeroLibreta();
		this.carreras = new ArrayList<>();
		e.getCarreras().forEach(c -> this.carreras.add(new Carrera_EstudianteDto(c)));
	}
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getNumeroLibreta() {
		return numeroLibreta;
	}

	public void setNumeroLibreta(int numeroLibreta) {
		this.numeroLibreta = numeroLibreta;
	}

	public ArrayList<Carrera_EstudianteDto> getCarreras() {
		return carreras;
	}

	public void setCarreras(ArrayList<Carrera_EstudianteDto> carreras) {
		this.carreras = carreras;
	}

	@Override
	public String toString() {
		return "EstudianteDto [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", genero=" + genero + ", ciudad=" + ciudad + ", numeroLibreta=" + numeroLibreta + ", carreras="
				+ carreras + "]";
	}
}
