package model;

public class Carro {
	private String modelo;
	private String marca;
	private int ano;
	private double preco;

	public Carro(String modelo, String marca, int ano, double preco) {
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

	public static Carro fromCSV(String linha) {
		String dados[] = linha.split(";");
		String modelo = dados[0];
		String marca = dados[1];
		int ano = Integer.parseInt(dados[2]);
		double preco = Double.parseDouble(dados[3]);
		return new Carro(modelo, marca, ano, preco);
	}
	
}
