package repositories;

import java.util.List;

import javax.persistence.EntityManager;

import dtos.CarreraDto;
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

}
