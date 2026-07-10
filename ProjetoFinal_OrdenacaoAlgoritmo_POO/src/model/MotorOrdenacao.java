package model;

/**
 * Classe ponte entre o Java (POO) e o motor gráfico em C++ (CG).
 *
 * Os métodos abaixo NÃO possuem implementação em Java -- eles serão
 * implementados em C++ (motor.cpp) e carregados em tempo de execução
 * via System.loadLibrary("motor").
 *
 * Esta classe só serve para GERAR o contrato (header JNI). Ela não
 * poderá ser executada de verdade até a equipe de CG expor essas
 * mesmas assinaturas no motor.cpp.
 */
public class MotorOrdenacao {

    static {
        // No Linux, o Java vai procurar por "libmotor.so"
        // No Windows, por "motor.dll"
        System.loadLibrary("motor");
    }

    /** Inicializa a janela OpenGL. Deve rodar em uma thread separada. */
    public native void init();

    /**
     * Envia o vetor a ser ordenado e qual algoritmo usar.
     * Chamado sempre que o usuário escolhe um algoritmo na tela Java.
     */
    public native void ordenar(int[] vetor, String algoritmo);

    /** Libera os recursos gráficos e fecha a janela OpenGL. */
    public native void cleanup();
}