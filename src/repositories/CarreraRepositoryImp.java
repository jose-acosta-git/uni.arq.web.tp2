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
	public CarreraDto obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarreraDto> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarreraDto guardar(CarreraDto dto) {
		Carrera c = new Carrera(dto.getNombre());
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		return dto;
	}

	@Override
	public void eliminar(CarreraDto dto) {
		// TODO Auto-generated method stub
		
	}

}
