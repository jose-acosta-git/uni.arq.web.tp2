package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Estudiante;

public class EstudiantesDeUnaCarrera {
	
	public static List<Estudiante> ObtenerEstudiantes(EntityManager em, String carrera, String ciudad) {
		String jpql =
				"SELECT e "
				+ "FROM Estudiante e "
				+ "JOIN e.carreras c "
				+ "WHERE c.carrera.nombre = ?1 "
				+ "AND e.ciudad = ?2 ";
		Query query = em.createQuery(jpql).setParameter(1, carrera).setParameter(2, ciudad);
		
		return query.getResultList();
	}

}
