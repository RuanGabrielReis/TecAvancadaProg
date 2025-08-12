package view;

import javax.swing.JOptionPane;

import model.ListaCarros;
import model.Carro;

public class AppCarros {
    public static void main(String[] args) {
        ListaCarros carros = new ListaCarros();
        int opcao;

        do {
            String menu = "1. Inserir carro\n"
                        + "2. Remover carro\n"
                        + "3. Alterar carro\n"
                        + "4. Listar carros\n"
                        + "5. Sair";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    String modelo = JOptionPane.showInputDialog("Modelo do carro:");
                    String marca = JOptionPane.showInputDialog("Marca do carro:");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Preco do carro:"));
                    int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano do carro:"));
                    Carro novoCarro = new Carro(modelo, marca, preco, ano);
                    carros.inserirCarro(novoCarro);
                    break;

                case 2:
                    modelo = JOptionPane.showInputDialog("Modelo do carro a remover:");
                    if (carros.removerCarro(modelo)) {
                        JOptionPane.showMessageDialog(null, "Carro removido com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Carro nao encontrado.");
                    }
                    break;

                case 3:
                    modelo = JOptionPane.showInputDialog("Modelo do carro a alterar:");
                    String novoModelo = JOptionPane.showInputDialog("Novo modelo:");
                    marca = JOptionPane.showInputDialog("Nova marca:");
                    preco = Double.parseDouble(JOptionPane.showInputDialog("Novo preço:"));
                    ano = Integer.parseInt(JOptionPane.showInputDialog("Novo ano:"));
                    if (carros.alterarCarro(modelo, novoModelo, marca, ano, preco) ){
                        JOptionPane.showMessageDialog(null, "Carro alterado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Carro nao encontrado.");
                    }
                    break;

                case 4:
                    //StringBuilder lista = new StringBuilder("Produtos cadastrados:\n");
                	String lista = "";
                    for (Carro carro : carros.listarCarros()) {
                        //lista.append(produto).append("\n");
                    	lista = lista + carro.getModelo() + ", " + carro.getMarca() + ", R$" + carro.getPreco() + ", do ano " + carro.getAno() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opçao invalida.");
                    break;
            }

        } while (opcao != 5);
    }
}
