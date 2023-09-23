package dtos;

public class CarreraInscriptosDto {
	
	private String carrera;
	private String inscriptos;
	
	public CarreraInscriptosDto(String carrera, String inscriptos) {
		super();
		this.carrera = carrera;
		this.inscriptos = inscriptos;
	}

	@Override
	public String toString() {
		return "CarreraInscriptosDto [carrera=" + carrera + ", inscriptos=" + inscriptos + "]";
	}
	
	
}
