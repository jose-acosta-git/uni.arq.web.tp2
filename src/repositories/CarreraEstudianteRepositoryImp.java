package repositories;

import java.util.List;

import javax.persistence.EntityManager;

import entidades.Carrera_Estudiante;

public class CarreraEstudianteRepositoryImp implements CarreraEstudianteRepository{

	public static CarreraEstudianteRepositoryImp instance = new CarreraEstudianteRepositoryImp();
	
	private CarreraEstudianteRepositoryImp() { }
	
	public static CarreraEstudianteRepositoryImp getInstance() {
		return instance;
	}

	@Override
	public Carrera_Estudiante obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carrera_Estudiante> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Carrera_Estudiante guardar(Carrera_Estudiante entity) {
		RepositoryFactory.getEntityManager().getTransaction().begin();
		RepositoryFactory.getEntityManager().persist(entity);
		RepositoryFactory.getEntityManager().getTransaction().commit();
		return entity;
	}

	@Override
	public void eliminar(Carrera_Estudiante entity) {
		// TODO Auto-generated method stub
		
	}
}
