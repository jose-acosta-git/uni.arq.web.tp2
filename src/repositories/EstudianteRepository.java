package repositories;

import java.util.List;

import entidades.Estudiante;

public interface EstudianteRepository extends BaseRepository<Estudiante, Integer> {
	Estudiante obtenerPorLibreta(int numeroLibreta);
	List<Estudiante> obtenerPorGenero(String genero);
	List<Estudiante> obtenerPorCarreraYCiudad(String carrera, String ciudad);
}