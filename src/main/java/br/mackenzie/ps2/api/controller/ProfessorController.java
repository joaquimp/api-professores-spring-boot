package br.mackenzie.ps2.api.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import br.mackenzie.ps2.api.entity.Professor;
import br.mackenzie.ps2.api.repository.ProfessorRepository;

@RestController
@RequestMapping("/api")
public class ProfessorController {
	
	@Autowired
	ProfessorRepository repositorio;
	
	
	@PostMapping("/professores")
	public Professor create(@RequestBody Professor professor) {
		String nome      = professor.getNome();
		String matricula = professor.getMatricula();
		String area      = professor.getArea();
		
		boolean erro = false;
		
		erro = erro || nome      == null ||      nome.trim().equals("");
		erro = erro || matricula == null || matricula.trim().equals("") || matricula.length() > 10;
		erro = erro || area      == null ||      area.trim().equals("");

		if(erro) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	
		return repositorio.save(professor);
	}

	
	@GetMapping("/professores")
	public Iterable<Professor> readAll() {
		return repositorio.findAll();
	}
	
	@GetMapping("/professores/{id}")
	public Professor readById(@PathVariable long id) {
		try {
			Optional<Professor> op = repositorio.findById(id);
		
			if(op.isPresent()) return op.get();
			
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro ao tentar buscar",
					ex);
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/professores/{id}")
	public Professor update(@RequestBody Professor professor, @PathVariable long id) {
		try {
			Optional<Professor> op = repositorio.findById(id);
		
			if(op.isPresent()) {
				Professor p = op.get();
				
				String nome      = professor.getNome();
				String matricula = professor.getMatricula();
				String area      = professor.getArea();
				
				if(nome      != null) p.setNome(nome);
				if(matricula != null) p.setMatricula(matricula);
				if(area      != null) p.setArea(area);
				
				return repositorio.save(p);
			}
			
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro ao tentar atualizar",
					ex);
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value="/professores/{id}", produces = "application/json")
	public Professor delete(@PathVariable long id) {
		try {
			Optional<Professor> op = repositorio.findById(id);
		
			if(op.isPresent()) {
				repositorio.deleteById(id);
				return op.get();
			}
			
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Erro ao tentar apagar",
					ex);
		}
		
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
}
