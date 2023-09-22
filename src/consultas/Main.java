package consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.*;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");
		EntityManager em = emf.createEntityManager();

		Estudiante felipe = AltaEstudiante.DarAltaEstudiante(em);
		MatricularEstudiante.Matricular(em, felipe);
		System.out.println(EstudiantePorLibreta.ObtenerEstudiante(em, 123456));
		
		em.close();
		emf.close();
	}

}
