package model;

public class Alunos {
	private String nome;
	private int idade;
	private double peso;
	private boolean formando;
	private char sexo;
	
	public Alunos (String nome, int idade, double peso, char sexo) {
		this.nome = nome;
		this.idade = idade;
		this.peso = peso;
		this.sexo = sexo;
		formando = false;
	}
	
	public Alunos () {
		
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setIdade(int idade) {
		this.idade=idade;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setPeso(double peso) {
		this.peso=peso;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setFormando(boolean formando) {
		this.formando=formando;
	}
	
	public boolean getFormando() {
		return formando;
	}
	
	public void setSexo(char sexo) {
		this.sexo=sexo;
	}
	
	public char getSexo() {
		return sexo;
	}

	@Override
	public String toString() {
		return "Seu nome é " + nome + ", sua idade é " + idade + ", seu peso é " + peso;
	}
	
}
