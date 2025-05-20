package model;

public class Caixa {
    private String corredor;
    private int posicao;
    private double peso;
    private String dono;

    // Getters
    public String getCorredor() {
        return corredor;
    }

    public int getPosicao() {
        return posicao;
    }

    public double getPeso() {
        return peso;
    }

    public String getDono() {
        return dono;
    }

    // Setters
    public void setCorredor(String corredor) {
        this.corredor = corredor;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    @Override
    public String toString() {
        return "[Dono: " + dono + "] [Corredor: " + corredor + "] [Posição: " + posicao +
               "] [Peso: " + peso + "]";
    }
}
