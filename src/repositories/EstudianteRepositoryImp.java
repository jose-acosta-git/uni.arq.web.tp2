package repositories;

import java.util.List;

import javax.persistence.EntityManager;

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
	public EstudianteDto obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstudianteDto> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstudianteDto guardar(EstudianteDto dto) {
		Estudiante e = new Estudiante(dto.getDni(), dto.getNombre(), dto.getApellido(), dto.getEdad(), dto.getGenero(), dto.getCiudad(), dto.getNumeroLibreta());
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		return dto;
	}

	@Override
	public void eliminar(EstudianteDto dto) {
		// TODO Auto-generated method stub
		
	}

}
