package io;

import data.DataContainer;
import enums.MathOperator;
import operators.MathematicalOperatorHandler;

/**
 * <p>
 * Classe responsávelpor lidar com a tradução da saída de dados (Comandos de saída)
 * </p>
 */
public class OutputHandler implements DataContainer {
    private static final String EMPTY_STRING = "";
    private static final String ASPAS_SIMPLES = "'";


    /**
     * <p>
     * Traduz a saída de dados de volta para o usuário
     * </p>
     *
     * @param linha linha a ser traduzida
     */
    public static void print(String linha) {
        linha = limparLinha(linha);
        System.out.println(getOutput(linha));
    }


    // ======= MÉTODOS AUXILIARES =======

    /**
     * <p>
     * Limpa a linha de caracteres e informações desnecessárias
     * </p>
     *
     * @param linha linha a ser limpa
     * @return linha limpa
     */
    private static String limparLinha(String linha) {
        return linha.replace("print", EMPTY_STRING)
                .replace(";", EMPTY_STRING)
                .replace("(", EMPTY_STRING)
                .replace(")", EMPTY_STRING);
    }

    /**
     * <p>
     * Extrai a mensagem a ser exibida
     * </p>
     *
     * @param linha linha que contém a mensagem
     * @return a mensagem a ser exibida
     */
    private static Object getOutput(String linha) {
        Object output;
        if (linha.startsWith(ASPAS_SIMPLES)) {
            if (linha.contains(MathOperator.ADD.get())) {
                String[] partes = linha.trim().split("\\+");

                Object var1, var2;

                var1 = partes[0].trim().replace(ASPAS_SIMPLES, EMPTY_STRING);
                var2 = partes[1].trim().replace(ASPAS_SIMPLES, EMPTY_STRING);

                if (variaveis.containsKey(var1)) {
                    var1 = variaveis.get(var1);
                }

                if (variaveis.containsKey(var2)) {
                    var2 = variaveis.get(var2);
                }

                output = String.valueOf(var1) + var2;
            } else {
                output = linha.replace(ASPAS_SIMPLES, EMPTY_STRING);
            }
        } else if (variaveis.containsKey(linha)) {
            output = variaveis.get(linha);
        } else if (linha.contains(MathOperator.ADD.get()) || linha.contains(MathOperator.SUB.get())
                || linha.contains(MathOperator.MULT.get()) || linha.contains(MathOperator.DIV.get())) {
            output = MathematicalOperatorHandler.mathOperator(linha);
        } else {
            output = linha;
        }
        return output;
    }

}
