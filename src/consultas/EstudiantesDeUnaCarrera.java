package consultas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dtos.EstudianteDto;
import entidades.Estudiante;

public class EstudiantesDeUnaCarrera {
	
	public static List<EstudianteDto> ObtenerEstudiantes(EntityManager em, String carrera, String ciudad) {
		String jpql =
				"SELECT e "
				+ "FROM Estudiante e "
				+ "JOIN e.carreras c "
				+ "WHERE c.carrera.nombre = ?1 "
				+ "AND e.ciudad = ?2 ";
		Query query = em.createQuery(jpql).setParameter(1, carrera).setParameter(2, ciudad);
		
		List<Estudiante> resultados = query.getResultList();
		List<EstudianteDto> dtos = new ArrayList<>();
		resultados.forEach(e -> dtos.add(new EstudianteDto(e)));
		
		return dtos;
	}

}
