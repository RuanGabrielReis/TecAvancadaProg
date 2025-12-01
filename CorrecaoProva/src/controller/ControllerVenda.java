package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Carro;
import model.Cliente;
import model.Venda;

public class ControllerVenda {

    private ArrayList<Venda> vendas = new ArrayList<>();
    private final String ARQUIVO = "vendas";

    private ControllerCliente controllerCliente;
    private ControllerCarro controllerCarro;

    public ControllerVenda(ControllerCliente cc, ControllerCarro ccar) {
        this.controllerCliente = cc;
        this.controllerCarro = ccar;
        carregarArquivo();
    }

    public void registrarVenda(Venda v) {
        vendas.add(v);
        salvarArquivo();
    }

    public ArrayList<Venda> listar() {
        return vendas;
    }

    private void carregarArquivo() {
        File f = new File(ARQUIVO);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                String cpf = dados[0];
                String modelo = dados[1];
                String data = dados[2];

                // Buscar cliente e carro existentes
                Cliente cliente = null;
                Carro carro = null;

                for (Cliente c : controllerCliente.listar()) {
                    if (c.getCpf().equals(cpf)) {
                        cliente = c;
                        break;
                    }
                }

                for (Carro car : controllerCarro.listar()) {
                    if (car.getModelo().equals(modelo)) {
                        carro = car;
                        break;
                    }
                }

                if (cliente != null && carro != null) {
                    vendas.add(new Venda(cliente, carro, data));
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar vendas: " + e.getMessage());
        }
    }

    private void salvarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Venda v : vendas) {
                bw.write(v.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar vendas.");
        }
    }
}
