package controller;

import model.Estatisticas;

public class OrdenacaoController {

    public void bubbleSort(int[] vetor, Estatisticas estatisticas) {
        estatisticas.zerar();
        int n = vetor.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                estatisticas.incrementarComparacoes();
                if(vetor[j] > vetor[j + 1]) {
                    //Troca
                    trocar(vetor, j, j + 1);
                    estatisticas.incrementarTrocas();
                }
            }
        }
    }

    public void insertionSort(int[] vetor, Estatisticas estatisticas) {
        estatisticas.zerar();
        int n = vetor.length;
        for(int i = 1; i < n; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while(j >= 0) {
                estatisticas.incrementarComparacoes();
                if(vetor[j] > chave) {
                    vetor[j + 1] = vetor[j];
                    estatisticas.incrementarTrocas();
                    j--;
                } else {
                    break;
                }
            }
            vetor[j + 1] = chave;
        }
    }

    public void selectionSort(int[] vetor, Estatisticas estatisticas) {
        estatisticas.zerar();
        int n = vetor.length;
        for(int i = 0; i < n - 1; i++) {
            int menorIndice = i;
            for(int j = i + 1; j < n; j++) {
                estatisticas.incrementarComparacoes();
                if(vetor[j] < vetor[menorIndice]) {
                    menorIndice = j;
                }
            }
            if(menorIndice != i) {
                trocar(vetor, i, menorIndice);
                estatisticas.incrementarTrocas();
            }
        }
    }

    private void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
