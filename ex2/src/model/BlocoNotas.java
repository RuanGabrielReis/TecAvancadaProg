package model;

import java.util.ArrayList;

public class BlocoNotas {
    private ArrayList<String> notas;

    public BlocoNotas() {
        notas = new ArrayList<>();
    }

    public void inserirNota(String nota) {
        notas.add(nota);
    }

    public boolean removerNota(int index) {
        if (index >= 0 && index < notas.size()) {
            notas.remove(index);
            return true;
        }
        return false;
    }

    public boolean alterarNota(int index, String novaNota) {
        if (index >= 0 && index < notas.size()) {
            notas.set(index, novaNota);
            return true;
        }
        return false;
    }

    public String buscarNota(int index) {
        if (index >= 0 && index < notas.size()) {
            return notas.get(index);
        }
        return null;
    }

    public void listarNotas() {
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota cadastrada.");
        } else {
            for (int i = 0; i < notas.size(); i++) {
                System.out.println((i + 1) + ". " + notas.get(i));
            }
        }
    }

    public int quantidadeNotas() {
        return notas.size();
    }
}