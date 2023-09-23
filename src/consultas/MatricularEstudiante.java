package consultas;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import entidades.Carrera;
import entidades.Carrera_Estudiante;
import entidades.Estudiante;

public class MatricularEstudiante {
	
	public static void Matricular(EntityManager em, Estudiante felipe, Carrera carrera) {
		em.getTransaction().begin();
		
		Carrera_Estudiante ce = new Carrera_Estudiante(felipe, carrera, LocalDate.now(), null);
		em.persist(ce);
		
		em.getTransaction().commit();
	}

}
