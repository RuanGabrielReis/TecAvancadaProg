package controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Carro;

public class ControllerCarro {
	
	private ArrayList<Carro> Lcarros = new ArrayList<>();
	private final String ARQUIVO = "carros";
	
	public ControllerCarro() {
		carregarArquivo();	
	}
	
	public void inserirCarro(Carro carros) {
		Lcarros.add(carros);
		salvarArquivo();
	}
	public ArrayList<Carro> listar() {
		return Lcarros;
	}
	public void removerCarro(String modelo) {
		int i = Buscar(modelo);
		if (i >= 0) {
			Lcarros.remove(i);
		}
		salvarArquivo();
	}
	public void alterarCarro(String modelo, Carro carro) {
		int i = Buscar(modelo);
		if (i >= 0) {
			Lcarros.set(i, carro);
		}
		salvarArquivo();
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

	private void carregarArquivo(){
		File arquivo = new File(ARQUIVO);
		
		if(!arquivo.exists()) return;	
		
		String linha;
		
		try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))){
			while( (linha = br.readLine()) != null) {
				Lcarros.add(Carro.fromCSV(linha));
			}
		} catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
		}
	}
	
	private void salvarArquivo() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))){
			for (Carro c : Lcarros) {
				bw.write(c.toCSV());
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 