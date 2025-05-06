package model;

public class Disciplina {
	private String nome;
	private String professor;
	private int semestre;
	private boolean ofertada;
	
	public Disciplina (String nome, String professor, int semestre, boolean ofertada) {
		this.nome = nome;
		this.professor = professor;
		this.semestre = semestre;
		this.ofertada = ofertada;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setProfessor(String professor) {
		this.professor=professor;
	}
	
	public String getProfessor() {
		return professor;
	}
	
	public void setSemestre(int semestre) {
		this.semestre=semestre;
	}
	
	public int getSemestre() {
		return semestre;
	}
	
	public void setOfertada(boolean ofertada) {
		this.ofertada=ofertada;
	}
	
	public boolean getOfertada() {
		return ofertada;
	}
	
	@Override
	public String toString() {
		return "O nome da turma é " + nome + ", o professor é " + professor + " e esta no " + semestre + " semestre.";
	}
	
}
