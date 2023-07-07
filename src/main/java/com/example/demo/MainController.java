package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// imports for use List, Map, String and Object
import java.lang.String;

import org.springframework.jdbc.core.JdbcTemplate;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called CursoRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private CursoRepository CursoRepository;

	@Autowired
  	private JdbcTemplate jdbcTemplate;

	@PostMapping(path="/nuevo") // Map ONLY POST Requests
	public @ResponseBody String addNewCurso (@RequestParam String name
			, @RequestParam Integer creditos) {
		Curso n = new Curso();
		n.setName(name);
		n.setCreditos(creditos);
		CursoRepository.save(n);
		return "Saved";
	}

	@DeleteMapping(path="/eliminar")
	public @ResponseBody String delCurso (@RequestParam Integer id) {
		Curso n = new Curso();
		n.setId(id);
		CursoRepository.delete(n);
		return "Deleted";
	}



	@GetMapping(path="/listar")
	public @ResponseBody Iterable<Curso> getAllCursos() {
		return CursoRepository.findAll();
	}




}
