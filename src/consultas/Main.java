package consultas;

import java.time.LocalDate;

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
		Estudiante laura = AltaEstudiantes.DarAltaEstudiantes(em, 80123123, "Laura", "Gonzalez", 22, "femenino", "Bahia Blanca", 987654);
		Estudiante luis = AltaEstudiantes.DarAltaEstudiantes(em, 90123123, "Luis", "Martinez", 24, "masculino", "Tandil", 123789);
		Estudiante ana = AltaEstudiantes.DarAltaEstudiantes(em, 100123123, "Ana", "Fernandez", 20, "femenino", "Azul", 567890);

		//2b
		System.out.println("\n******** Alta de carreras y matriculaciones: ********\n");
		Carrera tudai = new Carrera("TUDAI");
		Carrera licMat = new Carrera("Lic en Matematicas");
		Carrera profeIng = new Carrera("Profesorado de ingles");
		Carrera profeLit = new Carrera("Profesorado de literatura");
		
		persistirCarreras(tudai, licMat, em);
		persistirCarreras(profeIng, profeLit, em);
		
		// Matricula estudiantes
		LocalDate ingreso1 = LocalDate.of(2018, 3, 1); // A�o, mes, d�a
		LocalDate egreso1 = LocalDate.of(2022, 12, 18);
		LocalDate ingreso2 = LocalDate.of(2016, 4, 2);
		LocalDate egreso2 = null; // si es null significa que no egreso aun
		LocalDate ingreso3 = LocalDate.now(); // el ingreso es la fecha actual
		LocalDate egreso3 = null;
		LocalDate ingreso4 = LocalDate.of(2022, 5, 12);
		LocalDate egreso4 = null;
		LocalDate ingreso5 = LocalDate.of(2016, 5, 12);
		LocalDate egreso5 = LocalDate.of(2023, 4, 12);
		LocalDate ingreso6 = LocalDate.of(2016, 3, 22);
		LocalDate egreso6 = LocalDate.of(2022, 3, 14);
		LocalDate ingreso7 = LocalDate.of(2018, 5, 12);
		LocalDate egreso7 = LocalDate.of(2022, 8, 4);
		LocalDate ingreso8 = LocalDate.of(2017, 3, 3);
		LocalDate egreso8 = LocalDate.of(2022, 5, 12);
		LocalDate ingreso9 = LocalDate.of(2019, 7, 15);
		LocalDate egreso9 = LocalDate.of(2023, 6, 30);
		LocalDate ingreso10 = LocalDate.of(2018, 5, 20);
		LocalDate egreso10 = LocalDate.of(2022, 12, 15);
		LocalDate ingreso11 = LocalDate.of(2020, 8, 10);
		LocalDate egreso11 = LocalDate.of(2023, 5, 28);
		
		MatricularEstudiante.Matricular(em, felipe, tudai, ingreso1, egreso1);
		MatricularEstudiante.Matricular(em, juan, licMat, ingreso2, egreso2);
		MatricularEstudiante.Matricular(em, maria, tudai, ingreso3, egreso3);
		MatricularEstudiante.Matricular(em, carmen, profeIng, ingreso4, egreso4);
		MatricularEstudiante.Matricular(em, carmen, profeLit, ingreso5, egreso5);
		MatricularEstudiante.Matricular(em, miguel, licMat, ingreso6, egreso6);
		MatricularEstudiante.Matricular(em, carlos, tudai, ingreso7, egreso7);
		MatricularEstudiante.Matricular(em, isabel, profeLit, ingreso8, egreso8);
		MatricularEstudiante.Matricular(em, laura, tudai, ingreso9, egreso9);
		MatricularEstudiante.Matricular(em, luis, licMat, ingreso10, egreso10);
		MatricularEstudiante.Matricular(em, ana, profeLit, ingreso11, egreso11);
		
		em.close();
		em = emf.createEntityManager();
		
		//2c
//		System.out.println("\n******** Estudiantes ordenados por apellido: ********\n");
//		EstudiantesOrdenados.ObtenerEstudiantes(em).forEach(e -> System.out.println(e));
//		
//		//2d
//		System.out.println("\n******** Estudiante de libreta 123456: ********\n");
//		System.out.println(EstudiantePorLibreta.ObtenerEstudiante(em, 123456));
//		
//		//2e
//		System.out.println("\n******** Estudiantes de género masculino: ********\n");
//		EstudiantesPorGenero.ObtenerEstudiantes(em, "masculino").forEach(e -> System.out.println(e));
//		
//		//2f
//		System.out.println("\n******** Carreras con inscriptos, ordenadas por cantidad de inscriptos: ********\n");
//		CarrerasConInscriptosOrdenadas.ObtenerCarreras(em).forEach(c -> System.out.println(c));
//		
//		//2g
//		System.out.println("\n******** Estudiantes de la carrera TUDAI, que residen en Tres Arroyos: ********\n");
//		EstudiantesDeUnaCarrera.ObtenerEstudiantes(em, "TUDAI", "Tres Arroyos").forEach(e -> System.out.println(e));
//		
//		//3
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