package consultas;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.EntityManager;

import entidades.Carrera;
import entidades.Carrera_Estudiante;
import entidades.Estudiante;

public class MatricularEstudiante {
	
	public static void Matricular(EntityManager em, Estudiante felipe, Carrera carrera, LocalDate ingreso, LocalDate egreso) {
		em.getTransaction().begin();
		
		Carrera_Estudiante ce = new Carrera_Estudiante(felipe, carrera, ingreso, egreso);
		
		em.persist(ce);
		
		em.getTransaction().commit();
	}
}
