package model;

import java.util.ArrayList;

public class ListaCarros {
    private ArrayList<Carro> carros;

    public ListaCarros() {
        carros = new ArrayList<>();
    }

    public boolean inserirCarro(Carro carro) {
    	String modelo = carro.getModelo() ;
    	if (buscarCarro(modelo) == -1) {
    		carros.add(carro);
    		return true;
    	} else {
    		return false;
    	}
    }

    public boolean removerCarro(String modelo) {
        int posicao = buscarCarro(modelo);
        if (posicao >= 0) {
            carros.remove(posicao);
            return true;
        }
        return false;
    }
    
    public int buscarCarro(String modelo) {
    	int i = 0;
    	for (Carro carro : carros) {
    		if (carro.getModelo().equals(modelo)) {
    			return i;
    		}
    		i++;
    	}
    	return -1;
    }
    
    public ArrayList<Carro> listarCarros() {
    	return carros;
    }
    
    public boolean alterarCarro(String modelo, String novoModelo, String marca, int ano, double preco) {
    	int posicao = buscarCarro(modelo);
    	if (posicao >= 0) {
    		carros.get(posicao).setModelo(novoModelo);
    		carros.get(posicao).setMarca(marca);
    		carros.get(posicao).setAno(ano);
    		carros.get(posicao).setPreco(preco);
    		
    		return true;
    	} else {
    		return false;
    	}
    }
}