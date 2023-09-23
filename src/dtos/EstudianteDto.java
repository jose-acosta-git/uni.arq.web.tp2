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

	@Override
	public String toString() {
		return "EstudianteDto [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", genero=" + genero + ", ciudad=" + ciudad + ", numeroLibreta=" + numeroLibreta + ", carreras="
				+ carreras + "]";
	}
	
	
	
}
