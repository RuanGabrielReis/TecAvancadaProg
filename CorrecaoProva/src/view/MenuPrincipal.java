package view;

import javax.swing.JOptionPane;

import controller.ControllerCarro;
import controller.ControllerCliente;
import controller.ControllerVenda;
import model.Carro;
import model.Cliente;
import model.Venda;

public class MenuPrincipal {

    public static void main(String[] args) {

        ControllerCarro cc = new ControllerCarro();
        ControllerCliente ccli = new ControllerCliente();
        ControllerVenda cv = new ControllerVenda(ccli, cc);

        int opcao;

        do {
            String menu = """
                    MENU PRINCIPAL
                    1. Gerenciar Carros
                    2. Gerenciar Clientes
                    3. Vendas
                    4. Sair
                    """;

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
            case 1:
                submenuCarros(cc);
                break;

            case 2:
                submenuClientes(ccli);
                break;

            case 3:
                submenuVendas(cv, ccli, cc);
                break;
            }

        } while (opcao != 4);

    }

    // ---------------- SUBMENU CARROS ----------------------
    public static void submenuCarros(ControllerCarro cc) {

        int op;

        do {
            String menu = """
                    SUBMENU - CARROS
                    1. Inserir
                    2. Remover
                    3. Alterar
                    4. Listar
                    5. Voltar
                    """;

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
            case 1:
                String modelo = JOptionPane.showInputDialog("Modelo:");
                String marca = JOptionPane.showInputDialog("Marca:");
                double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
                int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));

                cc.inserirCarro(new Carro(modelo, marca, ano, preco));
                break;

            case 2:
                String rem = JOptionPane.showInputDialog("Modelo para remover:");
                cc.removerCarro(rem);
                break;

            case 3:
                String alt = JOptionPane.showInputDialog("Modelo que deseja alterar:");

                if (cc.Buscar(alt) == -1) {
                    JOptionPane.showMessageDialog(null, "Carro não encontrado.");
                    break;
                }

                String nmodelo = JOptionPane.showInputDialog("Novo modelo:");
                String nmarca = JOptionPane.showInputDialog("Nova marca:");
                double npreco = Double.parseDouble(JOptionPane.showInputDialog("Novo preço:"));
                int nano = Integer.parseInt(JOptionPane.showInputDialog("Novo ano:"));

                cc.alterarCarro(alt, new Carro(nmodelo, nmarca, nano, npreco));
                break;

            case 4:
                StringBuilder sb = new StringBuilder("Lista de carros:\n\n");
                for (Carro c : cc.listar()) sb.append(c).append("\n");
                JOptionPane.showMessageDialog(null, "<html><pre>" + sb + "</pre></html>");
                break;
            }

        } while (op != 5);
    }

    // ---------------- SUBMENU CLIENTES ----------------------
    public static void submenuClientes(ControllerCliente ccli) {

        int op;

        do {
            String menu = """
                    SUBMENU - CLIENTES
                    1. Inserir
                    2. Remover
                    3. Alterar
                    4. Listar
                    5. Voltar
                    """;

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
            case 1:
                String cpf = JOptionPane.showInputDialog("CPF:");
                String nome = JOptionPane.showInputDialog("Nome:");
                String contato = JOptionPane.showInputDialog("Contato:");

                ccli.inserirCliente(new Cliente(cpf, nome, contato));
                break;

            case 2:
                String rem = JOptionPane.showInputDialog("CPF para remover:");
                ccli.removerCliente(rem);
                break;

            case 3:
                String alt = JOptionPane.showInputDialog("CPF para alterar:");

                if (ccli.buscar(alt) == -1) {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    break;
                }

                String ncpf = JOptionPane.showInputDialog("Novo CPF:");
                String nnome = JOptionPane.showInputDialog("Novo nome:");
                String ncontato = JOptionPane.showInputDialog("Novo contato:");

                ccli.alterarCliente(alt, new Cliente(ncpf, nnome, ncontato));
                break;

            case 4:
                StringBuilder sb = new StringBuilder("Lista de clientes:\n\n");
                for (Cliente c : ccli.listar()) sb.append(c).append("\n");
                JOptionPane.showMessageDialog(null, "<html><pre>" + sb + "</pre></html>");
                break;
            }

        } while (op != 5);

    }

    // ---------------- SUBMENU VENDAS ----------------------
    public static void submenuVendas(ControllerVenda cv, ControllerCliente ccli, ControllerCarro cc) {

        int op;

        do {
            String menu = """
                    SUBMENU - VENDAS
                    1. Registrar Venda
                    2. Listar Vendas
                    3. Voltar
                    """;

            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
            case 1:
                String cpf = JOptionPane.showInputDialog("CPF do cliente:");
                Cliente cli = null;

                for (Cliente c : ccli.listar()) {
                    if (c.getCpf().equals(cpf)) {
                        cli = c;
                        break;
                    }
                }

                if (cli == null) {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    break;
                }

                String modelo = JOptionPane.showInputDialog("Modelo do carro:");
                Carro car = null;

                for (Carro c : cc.listar()) {
                    if (c.getModelo().equals(modelo)) {
                        car = c;
                        break;
                    }
                }

                if (car == null) {
                    JOptionPane.showMessageDialog(null, "Carro não encontrado.");
                    break;
                }

                String data = JOptionPane.showInputDialog("Data da venda (dd/mm/aaaa):");

                Venda v = new Venda(cli, car, data);
                cv.registrarVenda(v);

                JOptionPane.showMessageDialog(null, "Venda registrada!");
                break;

            case 2:
                StringBuilder sb = new StringBuilder("Lista de vendas:\n\n");
                for (Venda venda : cv.listar()) sb.append(venda).append("\n");
                JOptionPane.showMessageDialog(null, "<html><pre>" + sb + "</pre></html>");
                break;
            }

        } while (op != 3);

    }
}
