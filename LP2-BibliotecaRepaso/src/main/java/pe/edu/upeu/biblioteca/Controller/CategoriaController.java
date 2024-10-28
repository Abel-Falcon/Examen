package pe.edu.upeu.biblioteca.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.upeu.biblioteca.entity.Categoria;
import pe.edu.upeu.biblioteca.service.CategoriaService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	ResponseEntity<List<Categoria>> readAll() {
		try {
			List<Categoria> c = categoriaService.readAll();
			if (c.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			return new ResponseEntity<>(c,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Categoria> read(@PathVariable("id") Long id) {
		try {
			Categoria c = categoriaService.read(id).get();
			return new ResponseEntity<>(c,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	ResponseEntity<Categoria> update(@PathVariable("id") Long id, @Valid @RequestBody Categoria cat) {
		Optional<Categoria> c = categoriaService.read(id);
		if (c.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(categoriaService.create(cat), HttpStatus.CREATED);
		}
	}
	
	@PostMapping
	ResponseEntity<Categoria> create(@Valid @RequestBody Categoria cat) {
		try {
			Categoria c = categoriaService.create(cat);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<Categoria> delete(@PathVariable("id") Long id) {
		try {
			categoriaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
