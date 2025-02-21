package pe.edu.upeu.biblioteca.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.biblioteca.dao.CategoriaDao;
import pe.edu.upeu.biblioteca.entity.Categoria;
import pe.edu.upeu.biblioteca.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	private CategoriaDao categoriaDao;
	@Override
	public Categoria create(Categoria c) {
		// TODO Auto-generated method stub
		return categoriaDao.create(c);
	}

	@Override
	public Categoria update(Categoria c) {
		// TODO Auto-generated method stub
		return categoriaDao.update(c);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categoriaDao.delete(id);
	}

	@Override
	public Optional<Categoria> read(Long id) {
		// TODO Auto-generated method stub
		return categoriaDao.read(id);
	}

	@Override
	public List<Categoria> readAll() {
		// TODO Auto-generated method stub
		return categoriaDao.readAll();
	}
	
	
	
}
