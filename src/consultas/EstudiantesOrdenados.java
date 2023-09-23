package consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dtos.EstudianteDto;
import entidades.Estudiante;

public class EstudiantesOrdenados {
	
	public static List<EstudianteDto> ObtenerEstudiantes(EntityManager em) {
		String jpql = "SELECT e FROM Estudiante e ORDER BY e.apellido ASC";
		Query query = em.createQuery(jpql);
		
		List<Estudiante> resultados = query.getResultList();
		List<EstudianteDto> dtos = new ArrayList<>();
		resultados.forEach(e -> dtos.add(new EstudianteDto(e)));
		
		return dtos;
	}

}