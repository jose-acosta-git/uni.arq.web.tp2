package repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dtos.CarreraDto;
import dtos.CarreraInscriptosDto;
import entidades.Carrera;

public class CarreraRepositoryImp implements CarreraRepository {
	
	private EntityManager em = RepositoryFactory.getEntityManager();
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
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
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
		Query query = em.createQuery(jpql);
		List<Object[]> resultados = query.getResultList();
		
		List<CarreraInscriptosDto> dtos = new ArrayList<>();
		resultados.forEach(c -> 
			dtos.add( new CarreraInscriptosDto(c[0].toString(), c[1].toString()) )
		);
		
		return dtos;
	}

}
