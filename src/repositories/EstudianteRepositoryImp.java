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

}
