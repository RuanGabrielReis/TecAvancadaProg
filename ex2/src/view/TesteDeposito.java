package view;

import javax.swing.JOptionPane;

import model.Caixa;
import model.Deposito;

public class TesteDeposito {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        int opcao;

        do {
            String menu = "1. Adiciona caixa\n"
                        + "2. Remove caixa\n"
                        + "3. Procura caixa\n"
                        + "4. Muda localizaçao\n"
                        + "5. Lista caixas com mais q 10.0kg\n"
                        + "6. Sair";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    String dono = JOptionPane.showInputDialog("Nome do dono:");
                    String corredor = JOptionPane.showInputDialog("Corredor:");
                    int posicao = Integer.parseInt(JOptionPane.showInputDialog("Posiçao:"));
                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso:"));

                    Caixa caixa = new Caixa();
                    caixa.setDono(dono);
                    caixa.setCorredor(corredor);
                    caixa.setPosicao(posicao);
                    caixa.setPeso(peso);
                    deposito.adicionarCaixa(caixa);
                    break;

                case 2:
                    dono = JOptionPane.showInputDialog("Nome do dono da caixa para remover:");
                    if (deposito.removerCaixa(dono)) {
                        JOptionPane.showMessageDialog(null, "Caixa removida.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Caixa não encontrada.");
                    }
                    break;

                case 3:
                    dono = JOptionPane.showInputDialog("Nome do dono da caixa para procurar:");
                    int pos = deposito.buscarCaixa(dono);
                    if (pos >= 0) {
                        JOptionPane.showMessageDialog(null, "Caixa achada na posiçao " + pos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Caixa não encontrada.");
                    }
                    break;

                case 4:
                    dono = JOptionPane.showInputDialog("Nome do dono:");
                    corredor = JOptionPane.showInputDialog("Novo corredor:");
                    posicao = Integer.parseInt(JOptionPane.showInputDialog("Nova posiçao:"));

                    if (deposito.mudarLocalizacao(dono, corredor, posicao)) {
                        JOptionPane.showMessageDialog(null, "Localizaçao alterada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Caixa nao encontrada.");
                    }
                    break;

                case 5:
                    Caixa[] pesadas = deposito.caixasMaisPesadasQue(10.0);
                    StringBuilder sb = new StringBuilder("Caixas com peso com mais q 10.0kg:\n");
                    for (Caixa cx : pesadas) {
                        sb.append(cx).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opçao inválida.");
            }

        } while (opcao != 6);
    }
}
