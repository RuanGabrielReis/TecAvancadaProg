package model;

public class Venda {

    private Cliente cliente;
    private Carro carro;
    private String data;

    public Venda(Cliente cliente, Carro carro, String data) {
        this.cliente = cliente;
        this.carro = carro;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    // Para salvar no arquivo
    public String toCSV() {
        return cliente.getCpf() + ";" +
               carro.getModelo() + ";" +
               data;
    }

    // Ao carregar do arquivo, precisamos localizar o Cliente e o Carro no sistema
    public static Venda fromCSV(String linha, Cliente cliente, Carro carro) {
        String[] dados = linha.split(";");
        String data = dados[2];
        return new Venda(cliente, carro, data);
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + 
               " | Carro: " + carro.getModelo() +
               " | Data: " + data;
    }
}
