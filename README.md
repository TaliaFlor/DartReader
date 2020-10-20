# Interpretador Dart

<p>
Projeto feito para a cadeira de Paradigmas de Linguagens de Programação da Universidade Católica de Pernambuco no período 2020.2.
</p>

<p>
Esse programa é um interpretador de um código Dart simples feito em Java.
</p>

# Features

- Definição de variáveis de tipos primitivos 
    - int
    - double
    - num
    - boolean
    - string
- Comando de controle de fluxo de forma limitada (não suporta ifs aninhados)
    - if-elseif-else
- Comandos de entrada e saída
- Operações matemáticas básicas
    - soma
    - subtração
    - multiplicação
    - divisão
- Comandos de atribuição (sem ou com uma operação básica)
- Operadores de comparação (um por operação)
    - igual
    - diferente
    - menor que
    - maior que
    - menor ou igual a
    - maior ou igual a
- Operadores relacionais
    - or
    - and

<p>Para saber mais olhe as issues e as milestones.</p>


# Run

O projeto já vem com um código Dart de exemplo pronto para ser interpretado, encontrado em `src/main/resources/Calculadora.dart`. O projeto está configurado para rodar este arquivo especificamente, portanto caso queira-se rodar outro código deve-se entrar na classe `file.ReaderManager` e mudar a variável `nomeArquivo`, mantendo a extensão `.dart`.

Para rodar o projeto basta apenas rodar o `main`.
