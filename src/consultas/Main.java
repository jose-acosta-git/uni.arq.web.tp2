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
		Estudiante felipe = AltaEstudiantes.DarAltaEstudiantes(em, 50123123, "Felipe", "Morales", 28, "masculino", "Tres Arroyos", 123456);
		Estudiante juan = AltaEstudiantes.DarAltaEstudiantes(em, 60123123, "Juan", "Fernandez", 23, "masculino", "Tandil", 234567);
		Estudiante maria = AltaEstudiantes.DarAltaEstudiantes(em, 70123123, "Maria", "Gonzales", 21, "femenino", "Tres Arroyos", 345678);
		
		//2b
		Carrera tudai = new Carrera("TUDAI");
		Carrera licMat = new Carrera("Lic en Matematicas");
		persistirCarreras(tudai, licMat, em);
		
		MatricularEstudiante.Matricular(em, felipe, tudai);
		MatricularEstudiante.Matricular(em, juan, licMat);
		MatricularEstudiante.Matricular(em, maria, tudai);
		
		//2c
		EstudiantesOrdenados.ObtenerEstudiantes(em).forEach(e -> System.out.println(e));
		
		//2d
		System.out.println(EstudiantePorLibreta.ObtenerEstudiante(em, 123456));
		
		//2e
		EstudiantesPorGenero.ObtenerEstudiantes(em, "masculino").forEach(e -> System.out.println(e));
		
		//2f
		CarrerasConInscriptosOrdenadas.ObtenerCarreras(em).forEach(c -> System.out.println("Carrera:" + c[0] + " Inscriptos:" + c[1]));
		
		//2g
		EstudiantesDeUnaCarrera.ObtenerEstudiantes(em, "TUDAI", "Tres Arroyos").forEach(e -> System.out.println(e));
		
		em.close();
		emf.close();
	}
	
	public static void persistirCarreras(Carrera c1, Carrera c2, EntityManager em) {
		em.getTransaction().begin();
		em.persist(c1);
		em.persist(c2);
		em.getTransaction().commit();
	}

}