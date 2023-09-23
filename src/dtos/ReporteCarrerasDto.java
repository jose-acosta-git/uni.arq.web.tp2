package dtos;

public class ReporteCarrerasDto {
	private String nombreCarrera;
    private Integer anio;
    private int inscriptos;
    private int egresados;

    public ReporteCarrerasDto(String nombreCarrera, Integer anio, int inscriptos, int egresados) {
        this.nombreCarrera = nombreCarrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    @Override
    public String toString() {
        return "CarreraReportDto [nombreCarrera=" + nombreCarrera + ", anio=" + anio + ", inscriptos=" + inscriptos + ", egresados=" + egresados + "]";
    }
}
