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
		System.out.println("\n******** Alta de estudiantes: ********\n");
		Estudiante felipe = AltaEstudiantes.DarAltaEstudiantes(em, 50123123, "Felipe", "Morales", 28, "masculino", "Tres Arroyos", 123456);
		Estudiante juan = AltaEstudiantes.DarAltaEstudiantes(em, 60123123, "Juan", "Fernandez", 23, "masculino", "Tandil", 234567);
		Estudiante maria = AltaEstudiantes.DarAltaEstudiantes(em, 70123123, "Maria", "Gonzales", 21, "femenino", "Tres Arroyos", 345678);
		Estudiante carmen = AltaEstudiantes.DarAltaEstudiantes(em, 61121683, "Carmen", "García", 30, "femenino", "Tres Arroyos", 2316267);
		Estudiante miguel = AltaEstudiantes.DarAltaEstudiantes(em, 10143829, "Miguel", "Torres", 25, "masculino", "Bahia Blanca", 508709);
		Estudiante carlos = AltaEstudiantes.DarAltaEstudiantes(em, 71216198, "Carlos", "Pérez", 53, "masculino", "Tandil", 206568);
		Estudiante isabel = AltaEstudiantes.DarAltaEstudiantes(em, 90523823, "Isabel", "Fernández", 29, "femenino", "Azul", 396698);

		//2b
		System.out.println("\n******** Alta de carreras y matriculaciones: ********\n");
		Carrera tudai = new Carrera("TUDAI");
		Carrera licMat = new Carrera("Lic en Matematicas");
		Carrera profeIng = new Carrera("Profesorado de ingles");
		Carrera profeLit = new Carrera("Profesorado de literatura");
		
		persistirCarreras(tudai, licMat, em);
		persistirCarreras(profeIng, profeLit, em);
		
		MatricularEstudiante.Matricular(em, felipe, tudai, 2, 5);
		MatricularEstudiante.Matricular(em, juan, licMat, 2, 0);
		MatricularEstudiante.Matricular(em, maria, tudai, 5, 1);
		MatricularEstudiante.Matricular(em, carmen, profeIng, 4, 0);
		MatricularEstudiante.Matricular(em, carmen, profeLit, 0, 0);
		MatricularEstudiante.Matricular(em, miguel, licMat, 5, 2);
		MatricularEstudiante.Matricular(em, carlos, tudai, 5, 0);
		MatricularEstudiante.Matricular(em, isabel, profeLit, 5, 1);
		
		em.close();
		em = emf.createEntityManager();
		
		//2c
		System.out.println("\n******** Estudiantes ordenados por apellido: ********\n");
		EstudiantesOrdenados.ObtenerEstudiantes(em).forEach(e -> System.out.println(e));
		
		//2d
		System.out.println("\n******** Estudiante de libreta 123456: ********\n");
		System.out.println(EstudiantePorLibreta.ObtenerEstudiante(em, 123456));
		
		//2e
		System.out.println("\n******** Estudiantes de género masculino: ********\n");
		EstudiantesPorGenero.ObtenerEstudiantes(em, "masculino").forEach(e -> System.out.println(e));
		
		//2f
		System.out.println("\n******** Carreras con inscriptos, ordenadas por cantidad de inscriptos: ********\n");
		CarrerasConInscriptosOrdenadas.ObtenerCarreras(em).forEach(c -> System.out.println(c));
		
		//2g
		System.out.println("\n******** Estudiantes de la carrera TUDAI, que residen en Tres Arroyos: ********\n");
		EstudiantesDeUnaCarrera.ObtenerEstudiantes(em, "TUDAI", "Tres Arroyos").forEach(e -> System.out.println(e));
		
		//3
		System.out.println("\n******** Reporte de carreras: ********\n");
		ReporteDeCarreras.ObtenerReporte(em).forEach(e -> System.out.println(e));
		
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