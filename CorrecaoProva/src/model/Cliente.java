package model;

public class Cliente {

    private String cpf;
    private String nome;
    private String contato;

    public Cliente(String cpf, String nome, String contato) {
        this.cpf = cpf;
        this.nome = nome;
        this.contato = contato;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    // Persistência em arquivo (CSV)
    public String toCSV() {
        return cpf + ";" + nome + ";" + contato;
    }

    public static Cliente fromCSV(String linha) {
        String[] dados = linha.split(";");
        return new Cliente(dados[0], dados[1], dados[2]);
    }

    @Override
    public String toString() {
        return String.format("%12s %20s %15s", cpf, nome, contato);
    }
}
