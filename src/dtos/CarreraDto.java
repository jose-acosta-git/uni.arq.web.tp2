package dtos;

import java.util.ArrayList;

import entidades.Carrera;

public class CarreraDto {
	
	private String nombre;
	private ArrayList<Carrera_EstudianteDto> estudiantes;
	
	public CarreraDto(String nombre) {
		this.nombre = nombre;
		this.estudiantes = new ArrayList<>();
	}
	
	public CarreraDto(Carrera carrera) {
		this.nombre = carrera.getNombre();
		this.estudiantes = new ArrayList<>();
		carrera.getEstudiantes().forEach(e -> this.estudiantes.add(new Carrera_EstudianteDto(e)));
	}
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return "CarreraDto [nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
	}

	
}
