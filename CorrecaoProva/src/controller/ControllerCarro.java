package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Carro;

public class ControllerCarro {
	
	private ArrayList<Carro> Lcarros = new ArrayList<>();
	private final String ARQUIVO = "carros";
	
	public ControllerCarro() {
		try {
			carregarArquivo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inserirCarro(Carro carros) {
		Lcarros.add(carros);
	}
	public ArrayList<Carro> listar() {
		return Lcarros;
	}
	public void removerCarro(String modelo) {
		int i = Buscar(modelo);
		if (i >= 0) {
			Lcarros.remove(i);
		}
	}
	public void alterarCarro(String modelo, Carro carro) {
		int i = Buscar(modelo);
		if (i >= 0) {
			Lcarros.set(i, carro);
		}
	}
	public int Buscar(String modelo) {
		int i = 0;
		for (Carro carros : Lcarros) {
			if (carros.getModelo().equals(modelo)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private void carregarArquivo() throws FileNotFoundException {
		File arquivo = new File(ARQUIVO);
		
		if(!arquivo.exists()) return;		
		
		BufferedReader br = new BufferedReader(new FileReader(ARQUIVO));
		
		String linha;
		try {
			while( (linha = br.readLine()) != null) {
				Lcarros.add(Carro.fromCSV(linha));
			}
		} catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
		}
	}
}
 