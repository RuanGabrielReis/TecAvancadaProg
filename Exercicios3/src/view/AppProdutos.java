package view;

import javax.swing.JOptionPane;

import model.ListaProdutos;
import model.Produto;

public class AppProdutos {
    public static void main(String[] args) {
        ListaProdutos produtos = new ListaProdutos();
        int opcao;

        do {
            String menu = "1. Inserir produto\n"
                        + "2. Remover produto\n"
                        + "3. Alterar produto\n"
                        + "4. Listar produtos\n"
                        + "5. Sair";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Nome do produto:");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Preco do produto:"));
                    int qtt = Integer.parseInt(JOptionPane.showInputDialog("Telefone do cliente:"));
                    Produto novoProduto = new Produto(nome, preco, qtt);
                    produtos.inserirProduto(novoProduto);
                    break;

                case 2:
                    nome = JOptionPane.showInputDialog("Nome do produto a remover:");
                    if (produtos.removerProduto(nome)) {
                        JOptionPane.showMessageDialog(null, "Produto removido com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente nao encontrado.");
                    }
                    break;

                case 3:
                    nome = JOptionPane.showInputDialog("Nome do produto a alterar:");
                    String novoNome = JOptionPane.showInputDialog("Novo nome:");
                    preco = Double.parseDouble(JOptionPane.showInputDialog("Novo preço:"));
                    qtt = Integer.parseInt(JOptionPane.showInputDialog("Nova quantidade:"));
                    if (produtos.alterarProduto(nome, novoNome, qtt, preco) {
                        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente nao encontrado.");
                    }
                    break;

                case 4:
                    id = Integer.parseInt(JOptionPane.showInputDialog("ID cliente a listar:"));
                    Cliente cliente = banco.buscarClientePorId(id);
                    if (cliente != null) {
                        JOptionPane.showMessageDialog(null, cliente.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente nao encontrado.");
                    }
                    break;

                case 5:
                    StringBuilder lista = new StringBuilder("Clientes cadastrados:\n");
                    for (Cliente c : banco.listarTodos()) {
                        lista.append(c).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opçao invalida.");
                    break;
            }

        } while (opcao != 5);
    }
}
