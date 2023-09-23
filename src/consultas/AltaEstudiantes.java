package consultas;

import javax.persistence.EntityManager;

import entidades.Estudiante;

public class AltaEstudiantes {

	public static Estudiante DarAltaEstudiantes(EntityManager em) {
		em.getTransaction().begin();
		
		Estudiante felipe = new Estudiante(50123123, "Felipe", "Morales", 28, "masculino", "Tres Arroyos", 123456);
		Estudiante juan = new Estudiante(60123123, "Juan", "Fernandez", 23, "masculino", "Tandil", 234567);
		Estudiante maria = new Estudiante(70123123, "Maria", "Gonzales", 21, "femenino", "Azul", 345678);
		
		em.persist(juan);
		em.persist(maria);
		em.persist(felipe);
		
		em.getTransaction().commit();
		return felipe;
	}
	
}
