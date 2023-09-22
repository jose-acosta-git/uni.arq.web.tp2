package consultas;

import javax.persistence.EntityManager;

import entidades.Estudiante;

public class AltaEstudiante {

	public static Estudiante DarAltaEstudiante(EntityManager em) {
		
		em.getTransaction().begin();
		
		Estudiante felipe = new Estudiante(50123123, "Felipe", "Morales", 28, "masculino", "Tres Arroyos", 123456);
		
		em.persist(felipe);
		em.getTransaction().commit();
		
		return felipe;
	}
	
}
