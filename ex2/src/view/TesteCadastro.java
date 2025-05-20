package view;

import javax.swing.JOptionPane;

import model.BancoClientes;
import model.Cliente;

public class TesteCadastro {
    public static void main(String[] args) {
        BancoClientes banco = new BancoClientes();
        int opcao;

        do {
            String menu = "1. Insere cliente\n"
                        + "2. Remove cliente\n"
                        + "3. Altera cliente\n"
                        + "4. Lista cliente\n"
                        + "5. Lista clientes\n"
                        + "6. Sair";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente:"));
                    String nome = JOptionPane.showInputDialog("Nome do cliente:");
                    String fone = JOptionPane.showInputDialog("Telefone do cliente:");
                    Cliente novoCliente = new Cliente(id, nome, fone);
                    banco.inserirCliente(novoCliente);
                    break;

                case 2:
                    id = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente a remover:"));
                    if (banco.removerCliente(id)) {
                        JOptionPane.showMessageDialog(null, "Cliente removido com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente nao encontrado.");
                    }
                    break;

                case 3:
                    id = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente a alterar:"));
                    nome = JOptionPane.showInputDialog("Novo nome:");
                    fone = JOptionPane.showInputDialog("Novo telefone:");
                    if (banco.alterarCliente(id, nome, fone)) {
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

        } while (opcao != 6);
    }
}
