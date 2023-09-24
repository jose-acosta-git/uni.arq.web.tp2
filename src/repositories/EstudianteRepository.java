package repositories;

import entidades.Estudiante;

public interface EstudianteRepository extends BaseRepository<Estudiante, Integer> {
	Estudiante obtenerPorLibreta(int numeroLibreta);
}