package repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RepositoryFactory {
	
	public static final String DERBY = "Derby";
	public static final String MYSQL = "MySQL";
	
	private static RepositoryFactory instance = null;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	private RepositoryFactory() {}
	
	public static RepositoryFactory getInstance(String unidadPersistencia) {
		if (instance == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
			entityManager = entityManagerFactory.createEntityManager();
			instance = new RepositoryFactory();
			return instance;
		}
		return instance;
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
	public static void cerrarConexion() {
		RepositoryFactory.getEntityManager().close();
		RepositoryFactory.getEntityManagerFactory().close();
	}
	
	public static EstudianteRepositoryImp getEstudianteRepository() {
		return EstudianteRepositoryImp.getInstance();
	}

	public static CarreraRepositoryImp getCarreraRepository() {
		return CarreraRepositoryImp.getInstance();
	}
	
	public static CarreraEstudianteRepositoryImp getCarreraEstudianteRepository() {
		return CarreraEstudianteRepositoryImp.getInstance();
	}
}
