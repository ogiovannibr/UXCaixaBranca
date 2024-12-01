
# Análise do Fluxo de Controle - Etapa 3

Este documento descreve os pontos do fluxo de controle, calcula a complexidade ciclomática e apresenta os caminhos possíveis do código analisado.

---
![Diagrama](https://github.com/user-attachments/assets/6213e5f0-fdcf-47cf-95fc-1245793a446a)
---

## Descrição dos Pontos

### **Método conectarBD**

1. **N1**: Início do método `conectarBD`.
2. **N2**: Declaração e inicialização do objeto `Connection` como `null`.
3. **N3**: Entrada no bloco `try`.
4. **N4**: Carregamento do driver MySQL com `Class.forName`.
5. **N5**: Configuração da URL de conexão com os dados do banco.
6. **N6**: Estabelecimento da conexão com o banco através de `DriverManager.getConnection`.
7. **N7**: Entrada no bloco `catch` em caso de exceção.
8. **N8**: Retorno do objeto de conexão, seja válido ou `null`.

### **Método verificarUsuario**

9. **N9**: Início do método `verificarUsuario`.
10. **N10**: Declaração da consulta SQL e chamada ao método `conectarBD`.
11. **N11**: Construção da consulta SQL dinâmica com os parâmetros `login` e `senha`.
12. **N12**: Entrada no bloco `try`.
13. **N13**: Execução da consulta SQL e armazenamento dos resultados.
14. **N14**: Verificação condicional (`if`) para checar se existem resultados.
15. **N15**: Atribuição de valores às variáveis `result` e `nome` caso o resultado seja encontrado.
16. **N16**: Entrada no bloco `catch` em caso de exceção.
17. **N17**: Retorno do resultado:
    - Falha (quando a conexão falha ou ocorre exceção).
    - Sem resultados (quando não há correspondência).
    - Sucesso (quando há correspondência).

---

## Complexidade Ciclomática

A complexidade ciclomática é calculada pela fórmula:
\`\`\`
M = E - N + 2P
\`\`\`
- **E**: Número de arestas no grafo de fluxo.
- **N**: Número de nós no grafo.
- **P**: Número de componentes conectados (neste caso, 1).

### Cálculo
- Número de nós (N): 17.
- Número de arestas (E): 19 (com base nas conexões observadas).
- Componentes conectados (P): 1.

\`\`\`
M = 19 - 17 + 2 * 1 = 4
\`\`\`

A complexidade ciclomática é **4**, indicando que o código possui 4 caminhos independentes.

---

## Caminhos Identificados

### Método conectarBD
1. Caminho 1: N1 → N2 → N3 → N4 → N5 → N6 → N8.
2. Caminho 2: N1 → N2 → N3 → N7 → N8.

### Método verificarUsuario
1. Caminho 1: N9 → N10 → N11 → N12 → N13 → N14 → N15 → N17 (sucesso).
2. Caminho 2: N9 → N10 → N11 → N12 → N13 → N14 → N17 (sem resultados).
3. Caminho 3: N9 → N10 → N11 → N12 → N16 → N17 (falha).

---

## Conclusão

O código apresenta 4 caminhos distintos, com uma estrutura de fluxo bem definida e controlada. A complexidade ciclomática é moderada, sugerindo que o código pode ser mantido e testado de forma eficaz.
