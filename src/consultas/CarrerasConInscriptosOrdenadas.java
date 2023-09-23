package consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class CarrerasConInscriptosOrdenadas {
	
	public static List<Object[]> ObtenerCarreras(EntityManager em) {
		String jpql =
				"SELECT c.nombre, COUNT(ce) "
				+ "FROM Carrera c "
				+ "JOIN c.estudiantes ce "
				+ "GROUP BY c.nombre "
				+ "ORDER BY COUNT(ce) DESC";
		Query query = em.createQuery(jpql);
		
		return query.getResultList();
	}

}
