package consultas;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.EntityManager;

import entidades.Carrera;
import entidades.Carrera_Estudiante;
import entidades.Estudiante;

public class MatricularEstudiante {
	
	public static void Matricular(EntityManager em, Estudiante felipe, Carrera carrera, int ingreso, int egreso) {
		em.getTransaction().begin();
		
		// Por defecto el ingreso es la fecha actual y el egreso es null.
		Carrera_Estudiante ce = new Carrera_Estudiante(felipe, carrera, LocalDate.now(), null);
		
		// Si egreso es distinto de 0 entonces setea el egreso dentro de (egreso) años.
		if (egreso != 0) {
			ce.setEgreso(LocalDate.now().plus(Period.ofYears(egreso)));
		} 
		
		// Si ingreso es distinto de 0 entonces setea el ingreso (ingreso) años antes.
		if (ingreso != 0) {
			ce.setIngreso(LocalDate.now().minus(Period.ofYears(ingreso)));
		}
		
		em.persist(ce);
		
		em.getTransaction().commit();
	}
}
