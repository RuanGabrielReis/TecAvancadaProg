package model;

public class Carros {
	private String modelo;
	private String marca;
	private int ano;
	private double preco;
	
	public Carros(String modelo, String marca, int ano, double preco) {
		this.setModelo(modelo);
		this.setMarca(marca);
		this.setAno(ano);
		this.setPreco(preco);
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	

	
	
	
	
	
	
	

}
