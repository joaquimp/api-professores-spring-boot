package br.mackenzie.ps2.api.entity;

public class Professor {
	long id;
	String nome;
	String matricula;
	String area;
	
	public Professor() {}
	
	
	public Professor(long id, String nome, String matricula, String area) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.area = area;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}


	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}


	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
	
	

}
