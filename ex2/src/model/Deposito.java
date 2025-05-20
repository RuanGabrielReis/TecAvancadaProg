package model;

import java.util.ArrayList;

public class Deposito {
    private ArrayList<Caixa> caixas;

    public Deposito() {
        caixas = new ArrayList<>();
    }

    public void adicionarCaixa(Caixa caixa) {
        caixas.add(caixa);
    }

    public boolean removerCaixa(String dono) {
        int pos = buscarCaixa(dono);
        if (pos >= 0) {
            caixas.remove(pos);
            return true;
        }
        return false;
    }

    public int buscarCaixa(String dono) {
        for (int i = 0; i < caixas.size(); i++) {
            if (caixas.get(i).getDono().equalsIgnoreCase(dono)) {
                return i;
            }
        }
        return -1;
    }

    public boolean mudarLocalizacao(String dono, String novoCorredor, int novaPosicao) {
        int pos = buscarCaixa(dono);
        if (pos >= 0) {
            Caixa c = caixas.get(pos);
            c.setCorredor(novoCorredor);
            c.setPosicao(novaPosicao);
            return true;
        }
        return false;
    }

    public Caixa[] caixasMaisPesadasQue(double pesoLimite) {
        ArrayList<Caixa> resultado = new ArrayList<>();
        for (Caixa c : caixas) {
            if (c.getPeso() > pesoLimite) {
                resultado.add(c);
            }
        }
        return resultado.toArray(new Caixa[0]);
    }

    public void listarTodas() {
        if (caixas.isEmpty()) {
            System.out.println("Nenhuma caixa no depósito.");
        } else {
            for (Caixa c : caixas) {
                System.out.println(c);
            }
        }
    }
}
