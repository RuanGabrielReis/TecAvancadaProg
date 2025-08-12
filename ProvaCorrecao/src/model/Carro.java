package model;

public class Carro {
    private String modelo;
    private String marca;
    private double preco;
    private int ano;

    public Carro() {
        
    }
    
    public Carro(String modelo, String marca, double preco, int ano) {
    	this.modelo = modelo;
    	this.marca = marca;
    	this.preco = preco;
    	this.ano = ano;
    }

    public void setModelo(String modelo) {
    	this.modelo=modelo;
    }
    
    public String getModelo() {
    	return modelo;
    }
    
    public void setMarca(String marca) {
    	this.marca=marca;
    }
    
    public String getMarca() {
    	return marca;
    }
    
    public void setPreco(double preco) {
    	this.preco=preco;
    }
    
    public double getPreco() {
    	return preco;
    }
    
    public void setAno(int ano) {
    	this.ano=ano;
    }
    
    public int getAno() {
    	return ano;
    }
}