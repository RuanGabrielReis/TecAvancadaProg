package view;

import javax.swing.JOptionPane;

import controller.ControllerCarro;
import model.Carro;

public class TesteCarro {

    public static void main(String[] args) {
        
        ControllerCarro Lcarros = new ControllerCarro();
        
        int opcao;

        do {
            String menu = 
                    "1. Inserir carro\n" + 
                    "2. Remover carro\n" + 
                    "3. Alterar carro\n" + 
                    "4. Lista carro\n" +
                    "5. Sair";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
            case 1:
                String modelo = JOptionPane.showInputDialog("Modelo do carro");
                String marca = JOptionPane.showInputDialog("Marca do carro");
                double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do carro:"));
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano do carro:"));

                Carro novoCarro = new Carro(modelo, marca, ano, preco);
                Lcarros.inserirCarro(novoCarro);
                break;
                
            case 2: 
                String modeloRemover = JOptionPane.showInputDialog("Modelo para remover:");
                Lcarros.removerCarro(modeloRemover);
                break;

            case 3:
                String modeloAlterar = JOptionPane.showInputDialog("Modelo do carro a alterar:");

                if (Lcarros.Buscar(modeloAlterar) == -1) {
                    JOptionPane.showMessageDialog(null, "Carro não encontrado!");
                    break;
                }

                String novoModelo = JOptionPane.showInputDialog("Novo modelo:");
                String novaMarca = JOptionPane.showInputDialog("Nova marca:");
                double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("Novo preço:"));
                int novoAno = Integer.parseInt(JOptionPane.showInputDialog("Novo ano:"));

                Carro carroAlterado = new Carro(novoModelo, novaMarca, novoAno, novoPreco);
                Lcarros.alterarCarro(modeloAlterar, carroAlterado);

                JOptionPane.showMessageDialog(null, "Carro alterado com sucesso!");
                break;

            case 4:
                StringBuilder sb = new StringBuilder("Lista de carros\n\n");
                
                for (Carro c : Lcarros.listar()) {
                    sb.append(c).append("\n");
                }
                
                JOptionPane.showMessageDialog(null, "<html><pre>" + sb +"</pre></html>");
                break;
            }

        } while (opcao != 5);
    }
}
