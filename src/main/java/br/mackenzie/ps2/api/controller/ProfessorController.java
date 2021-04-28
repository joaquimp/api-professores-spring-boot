package br.mackenzie.ps2.api.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import br.mackenzie.ps2.api.entity.Professor;

@RestController
public class ProfessorController {
	
	private List<Professor> profs;
	private int countIds;
	
	public ProfessorController() {
		
		this.countIds = 0;
		
		Professor p1 = new Professor(this.countIds++, "Joaquim", "1130847", "Mobile");
		Professor p2 = new Professor(this.countIds++, "Cacique", "1234532", "Web");
		Professor p3 = new Professor(this.countIds++, "Basile", "3234212", "IA");
		
		
		this.profs = new ArrayList<>();
		this.profs.add(p1);
		this.profs.add(p2);
		this.profs.add(p3);
		
	}
	
	
	@PostMapping("/api/professores")
	public Professor create(@RequestBody Professor novoProf) {
		novoProf.setId(countIds++);
		profs.add(novoProf);
		return novoProf;
	}

	
	@GetMapping("/api/professores")
	public List<Professor> readAll() {
		return this.profs;
	}
	
	@GetMapping("/api/professores/{id}")
	public Professor readById(@PathVariable long id) {
		for(Professor p: this.profs) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		return null;
	}
	
	@PutMapping("/api/professores/{id}")
	public Professor update(@RequestBody Professor pUpdate, @PathVariable long id) {
		for(Professor p: this.profs) {
			if(p.getId() == id) {
				String nome = pUpdate.getNome();
				String matricula = pUpdate.getMatricula();
				String area = pUpdate.getArea();
				
				if (nome != null) p.setNome(nome);
				if (matricula != null) p.setMatricula(matricula);
				if (area != null) p.setArea(area);
				
				return p;
			}
		}
		
		return null;
	}
	
	@DeleteMapping(value="/api/professores/{id}", produces = "application/json")
	public Professor delete(@PathVariable long id) {
		for(Professor p: this.profs) {
			if(p.getId() == id) {
				profs.remove(p);
				return p;
			}
		}
		return null;
	}
}
