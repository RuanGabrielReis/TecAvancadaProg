package view;

import javax.swing.JOptionPane;

import model.BlocoNotas;

public class TesteBloco {
    public static void main(String[] args) {
        BlocoNotas bloco = new BlocoNotas();
        int opcao;

        do {
            String menu = "1. Inserir nota\n"
                        + "2. Remover nota\n"
                        + "3. Alterar nota\n"
                        + "4. Listar todas as notas\n"
                        + "5. Sair";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    String novaNota = JOptionPane.showInputDialog("Digite a nova nota:");
                    bloco.inserirNota(novaNota);
                    break;

                case 2:
                    bloco.listarNotas();
                    int removerIndex = Integer.parseInt(JOptionPane.showInputDialog("Número da nota para remover:")) - 1;
                    if (bloco.removerNota(removerIndex)) {
                        JOptionPane.showMessageDialog(null, "Nota removida.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Índice inválido.");
                    }
                    break;

                case 3:
                    bloco.listarNotas();
                    int alterarIndex = Integer.parseInt(JOptionPane.showInputDialog("Número da nota para alterar:")) - 1;
                    String novaMensagem = JOptionPane.showInputDialog("Digite a nova nota:");
                    if (bloco.alterarNota(alterarIndex, novaMensagem)) {
                        JOptionPane.showMessageDialog(null, "Nota alterada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Índice inválido.");
                    }
                    break;

                case 4:
                    bloco.listarNotas();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                    break;
            }

        } while (opcao != 5);
    }
}