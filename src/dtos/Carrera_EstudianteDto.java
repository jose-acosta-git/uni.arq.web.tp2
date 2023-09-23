package dtos;

import java.time.LocalDate;

import entidades.Carrera_Estudiante;

public class Carrera_EstudianteDto {
	
	private String estudiante;
	private String carrera;
	private LocalDate ingreso;
	private LocalDate egreso;
	
	public Carrera_EstudianteDto(Carrera_Estudiante carreraEstudiante) {
		super();
		this.estudiante = carreraEstudiante.getEstudiante().getNombre() + carreraEstudiante.getEstudiante().getApellido();
		this.carrera = carreraEstudiante.getCarrera().getNombre();
		this.ingreso = carreraEstudiante.getIngreso();
		this.egreso = carreraEstudiante.getEgreso();
	}

	@Override
	public String toString() {
		return "Carrera_EstudianteDto [estudiante=" + estudiante + ", carrera=" + carrera + ", ingreso=" + ingreso
				+ ", egreso=" + egreso + "]";
	}
	
	
}
