package model;

public class Estatisticas {
    private int comparacoes;
    private int trocas;
    private long tempoMs;

    public void zerar() {
        comparacoes = 0;
        trocas = 0;
        tempoMs = 0;
    }

    public void incrementarComparacoes() {
        comparacoes++;
    }

    public void incrementarTrocas() {
        trocas++;
    }

    public void setTempoMs(long tempoMs) {
        this.tempoMs = tempoMs;
    }

    public int getComparacoes() {return comparacoes;}
    public int getTrocas() {return trocas;}
    public long getTempoMs() {return tempoMs;}
}
