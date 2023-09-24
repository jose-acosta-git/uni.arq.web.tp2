package consultas;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dtos.CarreraDto;
import dtos.Carrera_EstudianteDto;
import dtos.EstudianteDto;
import entidades.*;
import repositories.CarreraEstudianteRepositoryImp;
import repositories.CarreraRepositoryImp;
import repositories.EstudianteRepositoryImp;
import repositories.RepositoryFactory;

public class Main {

	public static void main(String[] args) {
		RepositoryFactory rf = RepositoryFactory.getInstance("MySQL");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MySQL");
		EntityManager em = emf.createEntityManager();

		//2a
		System.out.println("\n******** Alta de estudiantes: ********\n");
		EstudianteRepositoryImp estudianteRepository = RepositoryFactory.getEstudianteRepository();
		
		Estudiante felipe = new Estudiante(50123123, "Felipe", "Morales", 28, "masculino", "Tres Arroyos", 123456);
		estudianteRepository.guardar(felipe);
		Estudiante juan = new Estudiante(60123123, "Juan", "Fernandez", 23, "masculino", "Tandil", 234567);
		estudianteRepository.guardar(juan);
		Estudiante maria = new Estudiante(70123123, "Maria", "Gonzales", 21, "femenino", "Tres Arroyos", 345678);
		estudianteRepository.guardar(maria);
		Estudiante carmen = new Estudiante(61121683, "Carmen", "García", 30, "femenino", "Tres Arroyos", 2316267);
		estudianteRepository.guardar(carmen);
		Estudiante miguel = new Estudiante(10143829, "Miguel", "Torres", 25, "masculino", "Bahia Blanca", 508709);
		estudianteRepository.guardar(miguel);
		Estudiante carlos = new Estudiante(71216198, "Carlos", "Pérez", 53, "masculino", "Tandil", 206568);
		estudianteRepository.guardar(carlos);
		Estudiante isabel = new Estudiante(90523823, "Isabel", "Fernández", 29, "femenino", "Azul", 396698);
		estudianteRepository.guardar(isabel);
		Estudiante laura = new Estudiante(80123123, "Laura", "Gonzalez", 22, "femenino", "Bahia Blanca", 987654);
		estudianteRepository.guardar(laura);
		Estudiante luis = new Estudiante(90123123, "Luis", "Martinez", 24, "masculino", "Tandil", 123789);
		estudianteRepository.guardar(luis);
		Estudiante ana = new Estudiante(100123123, "Ana", "Fernandez", 20, "femenino", "Azul", 567890);
		estudianteRepository.guardar(ana);
		

		//2b
		System.out.println("\n******** Alta de carreras y matriculaciones: ********\n");
		
		Carrera tudai = new Carrera("TUDAI");
		Carrera licMat = new Carrera("Lic en Matematicas");
		Carrera profeIng = new Carrera("Profesorado de ingles");
		Carrera profeLit = new Carrera("Profesorado de literatura");
		
		CarreraRepositoryImp carreraRepository = RepositoryFactory.getCarreraRepository();
		carreraRepository.guardar(tudai);
		carreraRepository.guardar(licMat);
		carreraRepository.guardar(profeIng);
		carreraRepository.guardar(profeLit);
		
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
		
		Carrera_Estudiante ingresoFelipe = new Carrera_Estudiante(felipe, tudai, ingreso1, egreso1);
		Carrera_Estudiante ingresoJuan = new Carrera_Estudiante(juan, licMat, ingreso2, egreso2);
		Carrera_Estudiante ingresoMaria = new Carrera_Estudiante(maria, tudai, ingreso3, egreso3);
		Carrera_Estudiante ingresoCarmen = new Carrera_Estudiante(carmen, profeIng, ingreso4, egreso4);
		Carrera_Estudiante ingresoCarmen2 = new Carrera_Estudiante(carmen, profeLit, ingreso5, egreso5);
		Carrera_Estudiante ingresoMiguel = new Carrera_Estudiante(miguel, licMat, ingreso6, egreso6);
		Carrera_Estudiante ingresoCarlos = new Carrera_Estudiante(carlos, tudai, ingreso7, egreso7);
		Carrera_Estudiante ingresoIsabel = new Carrera_Estudiante(isabel, profeLit, ingreso8, egreso8);
		Carrera_Estudiante ingresoLaura = new Carrera_Estudiante(laura, tudai, ingreso9, egreso9);
		Carrera_Estudiante ingresoLuis = new Carrera_Estudiante(luis, licMat, ingreso10, egreso10);
		Carrera_Estudiante ingresoAna = new Carrera_Estudiante(ana, profeLit, ingreso11, egreso11);
		
		CarreraEstudianteRepositoryImp carreraEstudianteRepository = RepositoryFactory.getCarreraEstudianteRepository();
		carreraEstudianteRepository.guardar(ingresoFelipe);
		carreraEstudianteRepository.guardar(ingresoJuan);
		carreraEstudianteRepository.guardar(ingresoMaria);
		carreraEstudianteRepository.guardar(ingresoCarmen);
		carreraEstudianteRepository.guardar(ingresoCarmen2);
		carreraEstudianteRepository.guardar(ingresoMiguel);
		carreraEstudianteRepository.guardar(ingresoCarlos);
		carreraEstudianteRepository.guardar(ingresoIsabel);
		carreraEstudianteRepository.guardar(ingresoLaura);
		carreraEstudianteRepository.guardar(ingresoLuis);
		carreraEstudianteRepository.guardar(ingresoAna);
		
		//2c
		System.out.println("\n******** Estudiantes ordenados por apellido: ********\n");
		estudianteRepository.obtenerTodos().forEach(e -> System.out.println(e));
		
		//2d
		System.out.println("\n******** Estudiante de libreta 123456: ********\n");
		System.out.println(estudianteRepository.obtenerPorLibreta(123456));
		
		//2e
		System.out.println("\n******** Estudiantes de género masculino: ********\n");
		estudianteRepository.obtenerPorGenero("masculino").forEach(e -> System.out.println(e));
		
		//2f
		System.out.println("\n******** Carreras con inscriptos, ordenadas por cantidad de inscriptos: ********\n");
		carreraRepository.obtenerCarrerasInscriptos().forEach(c -> System.out.println(c));
		
		//2g
		System.out.println("\n******** Estudiantes de la carrera TUDAI, que residen en Tres Arroyos: ********\n");
		estudianteRepository.obtenerPorCarreraYCiudad("TUDAI", "Tres Arroyos").forEach(e -> System.out.println(e));
		
		//3
		System.out.println("\n******** Reporte de carreras: ********\n");
		ReporteDeCarreras.ObtenerReporte(em).forEach(e -> System.out.println(e));
		
		em.close();
		emf.close();
	}
}