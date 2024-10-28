package pe.edu.upeu.biblioteca.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.biblioteca.entity.Categoria;

public interface CategoriaDao {
	
	Categoria create(Categoria c);
	Categoria update(Categoria c);
	void delete(Long id);
	Optional<Categoria> read(Long id);
	List<Categoria> readAll();

}
