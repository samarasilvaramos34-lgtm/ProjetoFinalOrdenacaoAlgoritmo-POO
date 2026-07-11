# Integração JNI — Compilação e Execução (Linux)

Este documento complementa o README principal e documenta especificamente os
passos para compilar o motor gráfico em C++ e rodar o projeto Java já
integrado com ele via JNI.

## 1. Pré-requisitos

```bash
# JDK completo (não só o JRE -- precisa do javac e do jni.h)
sudo apt-get update
sudo apt-get install openjdk-21-jdk-headless

# Bibliotecas gráficas (FreeGLUT + OpenGL)
sudo apt-get install freeglut3-dev mesa-common-dev libgl1-mesa-dev libglu1-mesa-dev
```

Verifique se o JDK está com o compilador disponível:
```bash
which javac
```
Se não retornar nada, o passo acima não foi concluído corretamente.

## 2. Descobrindo o caminho do JDK (`JAVA_HOME`)

O comando de compilação precisa do `jni.h`, que vem com o JDK. Para
descobrir o caminho exato na sua máquina:

```bash
readlink -f $(which javac)
```

Isso retorna algo como:
```
/usr/lib/jvm/java-21-openjdk-amd64/bin/javac
```

O caminho do `JAVA_HOME` é tudo antes de `/bin/javac`, ou seja:
```
/usr/lib/jvm/java-21-openjdk-amd64
```

> Use esse caminho diretamente no comando abaixo — depender da variável de
> ambiente `$JAVA_HOME` só funciona se ela já tiver sido exportada no
> terminal, o que não acontece por padrão.

## 3. Compilando a biblioteca nativa

Dentro da pasta com os arquivos `.cpp` do time de CG (`motor.cpp`,
`bubble.cpp`, `selection.cpp`, `insertion.cpp`, `algoritmos.h`,
`model_MotorOrdenacao.h`):

```bash
g++ -shared -fPIC motor.cpp bubble.cpp selection.cpp insertion.cpp \
  -I. \
  -I/usr/lib/jvm/java-21-openjdk-amd64/include \
  -I/usr/lib/jvm/java-21-openjdk-amd64/include/linux \
  -o libmotor.so \
  -lglut -lGL -lGLU
```

Ajuste o caminho do `-I` caso o `readlink` do passo 3 tenha retornado algo
diferente.

Isso gera o arquivo `libmotor.so` na pasta atual.

## 4. Posicionando a biblioteca no projeto Java

O `System.loadLibrary("motor")` procura por `libmotor.so` dentro da pasta
indicada por `-Djava.library.path`, **relativa ao diretório de onde o
comando `java` é executado** — não ao diretório do projeto em si.

```bash
mkdir -p ProjetoFinal_OrdenacaoAlgoritmo_POO/lib
cp libmotor.so ProjetoFinal_OrdenacaoAlgoritmo_POO/lib/
```

## 5. Executando

**Pelo terminal**, a partir da pasta `ProjetoFinal_OrdenacaoAlgoritmo_POO`:
```bash
cd ProjetoFinal_OrdenacaoAlgoritmo_POO
java -Djava.library.path=lib -cp bin view.TelaPrincipalAnimacao
```

**Pelo VS Code** (extensão Java), adicione `vmArgs` no `.vscode/launch.json`:
```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Rodar com motor gráfico",
            "request": "launch",
            "mainClass": "view.TelaPrincipalAnimacao",
            "vmArgs": "-Djava.library.path=lib"
        }
    ]
}
```

## 6. Erros comuns e soluções

| Erro | Causa | Solução |
|---|---|---|
| `fatal error: jni.h: Arquivo ou diretório inexistente` | `$JAVA_HOME` vazio, ou caminho do `-I` errado | Rode `readlink -f $(which javac)` e use o caminho direto no comando |
| `fatal error: GLUT/glut.h: Arquivo ou diretório inexistente` | Include específico de macOS, sem ajuste para Linux | Aplicar o `#ifdef __APPLE__` do passo 2 |
| `java.lang.UnsatisfiedLinkError: no motor in java.library.path: lib` | `libmotor.so` não está na pasta apontada por `-Djava.library.path`, ou nome do arquivo errado | Confirmar com `ls -la lib/` que o arquivo existe e se chama exatamente `libmotor.so` |