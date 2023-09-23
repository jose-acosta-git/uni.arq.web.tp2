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
		System.out.println(EstudiantesOrdenados.ObtenerEstudiantes(em));
		//2d
		System.out.println(EstudiantePorLibreta.ObtenerEstudiante(em, 123456));
		
		em.close();
		emf.close();
	}

}
