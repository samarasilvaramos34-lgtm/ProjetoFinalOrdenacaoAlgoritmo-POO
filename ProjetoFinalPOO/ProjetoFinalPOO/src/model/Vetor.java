package model;

public class Vetor {
    private int[] dados;

    public Vetor(int[] dados) {
        this.dados = dados;
    }

    public int[] getDados() {
        return dados;
    }

    public int tamanho() {
        return dados.length;
    }

    public Vetor copiar() {
        int[] copia = new int[dados.length];
        System.arraycopy(dados, 0, copia, 0, dados.length);
        return new Vetor(copia);
    }
}
