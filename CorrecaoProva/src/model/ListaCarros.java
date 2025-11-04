package model;

import java.util.ArrayList;

public class ListaCarros {

	private ArrayList<Carros> Lcarros;
	
	public ListaCarros() {
		Lcarros = new ArrayList<>();
	}
	
	
	public void inserirCarro(Carros carros) {
		Lcarros.add(carros);
		}
		
	public ArrayList<Carros> listar(){
		return Lcarros;
	}
	
	public void removerCarro(String modelo) {
		int i = Buscar(modelo);
		if(i >= 0) {
			Lcarros.remove(i);
		}
	}
	
	public void alterarCarro(String modelo, Carros carro) {
		int i = Buscar(modelo);
		if(i >= 0) {
			Lcarros.set(i, carro);
		}
	}
	
	
	public int Buscar(String modelo) {
		int i = 0;
		for(Carros carros : Lcarros) {
			if(carros.getModelo().equals(modelo)) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
}
