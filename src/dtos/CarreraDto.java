package dtos;

import java.util.ArrayList;

import entidades.Carrera;

public class CarreraDto {
	
	private String nombre;
	private ArrayList<Carrera_EstudianteDto> estudiantes;
	
	public CarreraDto(Carrera carrera) {
		this.nombre = carrera.getNombre();
		this.estudiantes = new ArrayList<>();
		carrera.getEstudiantes().forEach(e -> this.estudiantes.add(new Carrera_EstudianteDto(e)));
	}

	@Override
	public String toString() {
		return "CarreraDto [nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
	}

	
}
