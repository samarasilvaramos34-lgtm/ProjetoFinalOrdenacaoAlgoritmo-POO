package util;

import java.util.Random;

public class GeradorVetor {

    public static int[] gerarVetor(int quantidade, int limiteSuperior) {
        Random random = new Random();
        int[] vetor = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            vetor[i] = random.nextInt(limiteSuperior);
        }
        return vetor;
    }
}
