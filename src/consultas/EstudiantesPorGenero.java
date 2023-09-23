package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Estudiante;

public class EstudiantesPorGenero {
	
	public static List<Estudiante> ObtenerEstudiantes(EntityManager em, String genero) {
		String jpql = "SELECT e FROM Estudiante e WHERE e.genero = ?1";
		
		Query query = em.createQuery(jpql).setParameter(1, genero);
		
		List<Estudiante> resultados = query.getResultList();
		return resultados;
	}

}