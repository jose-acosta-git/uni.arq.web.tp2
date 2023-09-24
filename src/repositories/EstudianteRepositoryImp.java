package repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dtos.EstudianteDto;
import entidades.Estudiante;

public class EstudianteRepositoryImp implements EstudianteRepository {
	
	private EntityManager em = RepositoryFactory.getEntityManager();
	public static EstudianteRepositoryImp instance = new EstudianteRepositoryImp();
	
	private EstudianteRepositoryImp() { }
	
	public static EstudianteRepositoryImp getInstance() {
		return instance;
	}

	@Override
	public Estudiante obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estudiante> obtenerTodos() {
		String jpql = "SELECT e FROM Estudiante e ORDER BY e.apellido ASC";
		Query query = em.createQuery(jpql);
		
		List<Estudiante> resultados = query.getResultList();
		return resultados;
	}

	@Override
	public Estudiante guardar(Estudiante entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return entity;
	}

	@Override
	public void eliminar(Estudiante entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Estudiante obtenerPorLibreta(int numeroLibreta) {
		String jpql = "SELECT e FROM Estudiante e WHERE e.numeroLibreta = ?1";
		Query query = em.createQuery(jpql).setParameter(1, numeroLibreta);
		
		List<Estudiante> resultados = query.getResultList();
		return resultados.get(0);
	}

	@Override
	public List<Estudiante> obtenerPorGenero(String genero) {
		String jpql = "SELECT e FROM Estudiante e WHERE e.genero = ?1";
		Query query = em.createQuery(jpql).setParameter(1, genero);
		
		return query.getResultList();
	}

	@Override
	public List<Estudiante> obtenerPorCarreraYCiudad(String carrera, String ciudad) {
		String jpql =
				"SELECT e "
				+ "FROM Estudiante e "
				+ "JOIN e.carreras c "
				+ "WHERE c.carrera.nombre = ?1 "
				+ "AND e.ciudad = ?2 ";
		Query query = em.createQuery(jpql).setParameter(1, carrera).setParameter(2, ciudad);
		
		return query.getResultList();
	}

}
