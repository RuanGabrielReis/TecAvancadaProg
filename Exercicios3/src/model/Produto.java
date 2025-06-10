package model;

public class Produto {
    private String nome;
    private double preco;
    private int qtt;

    public Produto() {
        
    }
    
    public Produto(String nome, double preco, int qtt) {
    	this.nome = nome;
    	this.preco = preco;
    	this.qtt = qtt;
    }

    public void setNome(String nome) {
    	this.nome=nome;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public void setPreco(double preco) {
    	this.preco=preco;
    }
    
    public double getPreco() {
    	return preco;
    }
    
    public void setQtt(int qtt) {
    	this.qtt=qtt;
    }
    
    public int getQtt() {
    	return qtt;
    }
    
}