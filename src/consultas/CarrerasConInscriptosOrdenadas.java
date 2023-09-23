package consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dtos.CarreraInscriptosDto;
import dtos.EstudianteDto;
import entidades.Estudiante;


public class CarrerasConInscriptosOrdenadas {
	
	public static List<CarreraInscriptosDto> ObtenerCarreras(EntityManager em) {
		String jpql =
				"SELECT c.nombre, COUNT(ce) "
				+ "FROM Carrera c "
				+ "JOIN c.estudiantes ce "
				+ "GROUP BY c.nombre "
				+ "ORDER BY COUNT(ce) DESC";
		Query query = em.createQuery(jpql);
		List<Object[]> resultados = query.getResultList();
		
		List<CarreraInscriptosDto> dtos = new ArrayList<>();
		resultados.forEach(c -> 
			dtos.add( new CarreraInscriptosDto(c[0].toString(), c[1].toString()) )
		);
		
		return dtos;
	}

}
