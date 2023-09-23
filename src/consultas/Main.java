package consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.*;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");
		EntityManager em = emf.createEntityManager();

		//2a
		Estudiante felipe = AltaEstudiantes.DarAltaEstudiantes(em);
		//2b
		MatricularEstudiante.Matricular(em, felipe);
		//2c
		EstudiantesOrdenados.ObtenerEstudiantes(em).forEach(e -> System.out.println(e));
		//2d
		System.out.println(EstudiantePorLibreta.ObtenerEstudiante(em, 123456));
		//2e
		EstudiantesPorGenero.ObtenerEstudiantes(em, "masculino").forEach(e -> System.out.println(e));
		
		em.close();
		emf.close();
	}

}