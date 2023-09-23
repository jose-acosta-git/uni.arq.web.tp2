package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Estudiante;

public class EstudiantePorLibreta {
	
	public static Estudiante ObtenerEstudiante(EntityManager em, int numeroLibreta) {
		String jpql = "SELECT e FROM Estudiante e WHERE e.numeroLibreta = ?1";
		
		Query query = em.createQuery(jpql).setParameter(1, numeroLibreta);
		
		List<Estudiante> resultados = query.getResultList();
		return resultados.get(0);
	}

}
