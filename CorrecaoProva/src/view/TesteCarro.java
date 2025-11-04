package view;

import javax.swing.JOptionPane;

import controller.ControllerCarro;
import model.Carro;

public class TesteCarro {

	public static void main(String[] args) {
		
		ControllerCarro Lcarros = new ControllerCarro();
		
		int opcao;

		do {
			String menu = "1. Inserir carro\n" + "2. Remover carro\n" + "3. Alterar carro\n" + "4. Lista carro\n"
					+ "5. Sair";
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			switch (opcao) {
			case 1:
				String modelo = JOptionPane.showInputDialog("Modelo do carro");
				String marca = JOptionPane.showInputDialog("marca do carro");
				double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço Carro:"));
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano do Carro:"));
				Carro novoCarro = new Carro(modelo, marca, ano, preco);
				Lcarros.inserirCarro(novoCarro);
				break;
			}
		} while (opcao != 5);
	}
}