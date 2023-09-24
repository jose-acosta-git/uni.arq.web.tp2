package repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dtos.CarreraDto;
import dtos.CarreraInscriptosDto;
import dtos.ReporteCarrerasDto;
import entidades.Carrera;

public class CarreraRepositoryImp implements CarreraRepository {
	
	public static CarreraRepositoryImp instance = new CarreraRepositoryImp();
	
	private CarreraRepositoryImp() { }
	
	public static CarreraRepositoryImp getInstance() {
		return instance;
	}

	@Override
	public Carrera obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carrera> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrera guardar(Carrera entity) {
		RepositoryFactory.getEntityManager().getTransaction().begin();
		RepositoryFactory.getEntityManager().persist(entity);
		RepositoryFactory.getEntityManager().getTransaction().commit();
		return entity;
	}

	@Override
	public void eliminar(Carrera entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CarreraInscriptosDto> obtenerCarrerasInscriptos() {
		String jpql =
				"SELECT c.nombre, COUNT(ce) "
				+ "FROM Carrera c "
				+ "JOIN c.estudiantes ce "
				+ "GROUP BY c.nombre "
				+ "ORDER BY COUNT(ce) DESC";
		Query query = RepositoryFactory.getEntityManager().createQuery(jpql);
		List<Object[]> resultados = query.getResultList();
		
		List<CarreraInscriptosDto> dtos = new ArrayList<>();
		resultados.forEach(c -> 
			dtos.add( new CarreraInscriptosDto(c[0].toString(), c[1].toString()) )
		);
		
		return dtos;
	}

	@Override
	public List<ReporteCarrerasDto> obtenerReporteCarreras() {
		String jpql = 
				"SELECT c.nombre AS Carrera, " +
			    "FUNCTION('YEAR', ce.ingreso) AS Anio, " +
			    "COUNT(ce.id) AS Inscriptos, " +
			    "COUNT(CASE WHEN ce.egreso IS NOT NULL THEN 1 ELSE NULL END) AS Egresados " +
			    "FROM Carrera c " +
			    "LEFT JOIN c.estudiantes ce " +
			    "GROUP BY c.nombre, Anio " +
			    "ORDER BY c.nombre ASC, Anio ASC";
		Query query = RepositoryFactory.getEntityManager().createQuery(jpql);
		
		List<Object[]> resultados = query.getResultList();
		List<ReporteCarrerasDto> reporte = new ArrayList<>();
		
		resultados.forEach(c -> {
		    String nombreCarrera = c[0].toString();
		    Integer anio =  (Integer) (c[1]);
		    Long inscriptos =  (Long) c[2];
		    Long egresados =  (Long) c[3];
		    reporte.add(new ReporteCarrerasDto(nombreCarrera, anio, inscriptos.intValue(), egresados.intValue()));
		});
		return reporte;
	}

}
