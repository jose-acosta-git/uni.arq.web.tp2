package consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dtos.*;
import entidades.*;

public class ReporteDeCarreras {

	public static List<ReporteCarrerasDto> ObtenerReporte(EntityManager em) {
		String jpql = 
				"SELECT c.nombre AS Carrera, " +
			    "FUNCTION('YEAR', ce.ingreso) AS Anio, " +
			    "COUNT(ce.id) AS Inscriptos, " +
			    "COUNT(CASE WHEN ce.egreso IS NOT NULL THEN 1 ELSE NULL END) AS Egresados " +
			    "FROM Carrera c " +
			    "LEFT JOIN c.estudiantes ce " +
			    "GROUP BY c.nombre, Anio " +
			    "ORDER BY c.nombre ASC, Anio ASC";
		
		
		Query query = em.createQuery(jpql);
		List<Object[]> resultados = query.getResultList();
		
		List<ReporteCarrerasDto> reporte = new ArrayList<>();
		
		resultados.forEach(c -> {
		    String nombreCarrera = c[0].toString();
		    Integer anio =  (Integer) (c[1]);
		    Long inscriptos =  (Long) c[2];
		    Long egresados =  (Long) c[3];
		    reporte.add(new ReporteCarrerasDto(nombreCarrera, anio, inscriptos.intValue(), egresados.intValue()));
		});
		
		
		return new ArrayList<>(reporte);
	}
}
