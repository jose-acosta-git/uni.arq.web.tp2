package consultas;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import entidades.Carrera;
import entidades.Carrera_Estudiante;
import entidades.Estudiante;

public class MatricularEstudiante {
	
	public static void Matricular(EntityManager em, Estudiante felipe) {
		em.getTransaction().begin();
		
		Carrera tudai = new Carrera("TUDAI");
		em.persist(tudai);
		
		Carrera_Estudiante tudaiFelipe = new Carrera_Estudiante(felipe, tudai, LocalDate.now(), null);
		em.persist(tudaiFelipe);
		
		em.getTransaction().commit();
		em.close();
	}

}
