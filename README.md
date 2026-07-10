# Visualizador de Algoritmos de Ordenação

## Contexto Acadêmico

Este sistema faz parte do Projeto Interdisciplinar que promove a integração curricular entre as disciplinas de Programação Orientada a Objetos (POO) e Computação Gráfica (CG) do Departamento de Ciência da Computação da Universidade Federal de Rondônia (UNIR), sob a orientação do Prof. Dr. Lucas Marques da Cunha.

## Descrição do Projeto

A aplicação é um visualizador desktop desenvolvido em **Java (Swing)** que permite gerar vetores de números aleatórios e executar diferentes algoritmos de ordenação sobre eles, exibindo em tempo real:

- Número de **comparações** realizadas;
- Número de **trocas** realizadas;
- **Tempo de execução** do algoritmo;
- Mensagens de acompanhamento da execução.

O objetivo é oferecer uma ferramenta didática que una a lógica algorítmica (POO) à representação visual do processo de ordenação (CG).

## Funcionalidades

- Geração de vetores aleatórios com quantidade de elementos configurável;
- Seleção do algoritmo de ordenação a ser executado;
- Execução passo a passo com controle de velocidade;
- Painel de estatísticas (comparações, trocas e tempo);
- Log de mensagens do sistema;
- Reinício da simulação.

## Algoritmos Implementados

| Algoritmo        | Complexidade (pior caso) | Estável |
|-------------------|---------------------------|---------|
| Bubble Sort       | O(n²)                     | Sim     |
| Insertion Sort    | O(n²)                     | Sim     |
| Selection Sort    | O(n²)                     | Não     |

## Arquitetura

O projeto segue o padrão **MVC (Model-View-Controller)**, separando a lógica de negócio da interface gráfica:

```
src/
├── model/
│   ├── Vetor.java            # Encapsula o vetor de inteiros a ser ordenado
│   └── Estatisticas.java     # Armazena comparações, trocas e tempo de execução
│
├── util/
│   └── GeradorVetor.java     # Geração de vetores aleatórios
│
├── controller/
│   └── OrdenacaoController.java  # Lógica dos algoritmos de ordenação
│
└── view/
    └── TelaPrincipal.java    # Interface gráfica (Swing)
```

- **model** — representa os dados manipulados pela aplicação (vetor e estatísticas);
- **util** — classes auxiliares e utilitárias (geração de dados);
- **controller** — contém a lógica dos algoritmos de ordenação, isolada da interface;
- **view** — responsável exclusivamente pela apresentação visual (Swing).

## Tecnologias

- **Java** (Swing para interface gráfica)
- **Git/GitHub** para versionamento e trabalho colaborativo (fluxo de *pull requests*)

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/samarasilvaramos34-lgtm/ProjetoFinal-POO.git
   ```
2. Abra o projeto em uma IDE Java (Eclipse, IntelliJ ou VS Code com extensão Java);
3. Execute a classe `view.TelaPrincipal`, que contém o método `main`.