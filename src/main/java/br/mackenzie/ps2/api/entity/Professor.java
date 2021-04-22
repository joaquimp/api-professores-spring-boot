package br.mackenzie.ps2.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "professores")
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long id;
	@Column(nullable = false)
	String nome;
	@Column(nullable = false, length = 10)
	String matricula;
	@Column(nullable = false)
	String area;
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public String getMatricula() { return matricula; }
	public void setMatricula(String matricula) { this.matricula = matricula; }
	public String getArea() { return area; }
	public void setArea(String area) { this.area = area; }
}
