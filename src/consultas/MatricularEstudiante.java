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
		
		// Por defecto el ingreso es la fecha actual y el egreso es null.
		Carrera_Estudiante ce = new Carrera_Estudiante(felipe, carrera, ingreso, null);
				
		// Si egreso es distinto de null setea el egreso.
		if (egreso != null) {
			ce.setEgreso(egreso);
		}
		
		em.persist(ce);
		
		em.getTransaction().commit();
	}
}
