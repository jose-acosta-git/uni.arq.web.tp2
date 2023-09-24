package repositories;

import java.util.List;

public interface BaseRepository<T, ID> {
	
	T obtenerPorId(ID id);
	List<T> obtenerTodos();
	T guardar(T entity);
	void eliminar(T entity);
}
