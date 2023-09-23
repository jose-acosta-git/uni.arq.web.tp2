package consultas;

import javax.persistence.EntityManager;

import entidades.Estudiante;

public class AltaEstudiantes {

	public static Estudiante DarAltaEstudiantes(EntityManager em, int dni, String nombre, String apellido, int edad, String genero, String ciudad, int numeroLibreta) {
		em.getTransaction().begin();
		
		Estudiante e = new Estudiante(dni, nombre, apellido, edad, genero, ciudad, numeroLibreta);
		em.persist(e);
		
		em.getTransaction().commit();
		return e;
	}
	
}
