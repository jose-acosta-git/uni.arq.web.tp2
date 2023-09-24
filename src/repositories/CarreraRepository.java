package repositories;

import java.util.List;

import dtos.CarreraInscriptosDto;
import entidades.Carrera;

public interface CarreraRepository extends BaseRepository<Carrera, Integer> {
	List<CarreraInscriptosDto> obtenerCarrerasInscriptos();
}
