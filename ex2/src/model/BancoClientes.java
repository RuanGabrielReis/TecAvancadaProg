package model;

import java.util.ArrayList;

public class BancoClientes {
    private ArrayList<Cliente> clientes;

    public BancoClientes() {
        clientes = new ArrayList<>();
    }

    public void inserirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean removerCliente(int id) {
        int index = buscarCliente(id);
        if (index >= 0) {
            clientes.remove(index);
            return true;
        }
        return false;
    }

    public boolean alterarCliente(int id, String novoNome, String novoFone) {
        int index = buscarCliente(id);
        if (index >= 0) {
            Cliente c = clientes.get(index);
            c.setNome(novoNome);
            c.setFone(novoFone);
            return true;
        }
        return false;
    }

    public Cliente buscarClientePorId(int id) {
        int index = buscarCliente(id);
        if (index >= 0) {
            return clientes.get(index);
        }
        return null;
    }

    public ArrayList<Cliente> listarTodos() {
        return clientes;
    }

    private int buscarCliente(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
