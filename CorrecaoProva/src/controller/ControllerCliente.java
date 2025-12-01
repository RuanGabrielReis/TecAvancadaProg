package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Cliente;

public class ControllerCliente {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    private final String ARQUIVO = "clientes";

    public ControllerCliente() {
        carregarArquivo();
    }

    public void inserirCliente(Cliente c) {
        clientes.add(c);
        salvarArquivo();
    }

    public ArrayList<Cliente> listar() {
        return clientes;
    }

    public void removerCliente(String cpf) {
        int i = buscar(cpf);
        if (i >= 0) {
            clientes.remove(i);
            salvarArquivo();
        }
    }

    public void alterarCliente(String cpf, Cliente novo) {
        int i = buscar(cpf);
        if (i >= 0) {
            clientes.set(i, novo);
            salvarArquivo();
        }
    }

    public int buscar(String cpf) {
        int i = 0;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void carregarArquivo() {
        File f = new File(ARQUIVO);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                clientes.add(Cliente.fromCSV(linha));
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo de clientes: " + e.getMessage());
        }
    }

    private void salvarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Cliente c : clientes) {
                bw.write(c.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo de clientes.");
        }
    }
}
