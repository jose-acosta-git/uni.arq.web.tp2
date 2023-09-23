package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Estudiante;

public class EstudiantesOrdenados {
	
	public static List<Estudiante> ObtenerEstudiantes(EntityManager em) {
		String jpql = "SELECT e FROM Estudiante e ORDER BY e.apellido ASC";
		Query query = em.createQuery(jpql);
		
		List<Estudiante> resultados = query.getResultList();
		return resultados;
	}

}