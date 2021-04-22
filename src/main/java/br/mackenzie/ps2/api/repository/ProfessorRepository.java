package br.mackenzie.ps2.api.repository;


import org.springframework.data.repository.CrudRepository;
import br.mackenzie.ps2.api.entity.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
