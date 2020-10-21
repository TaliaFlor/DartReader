package io;

import data.DataContainer;
import enums.MathOperator;
import global.Constants;
import operators.MathOperatorHandler;
import util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Classe respons�vel por lidar com a interpreta��o da sa�da de dados (Comandos de sa�da)
 * </p>
 */
public class OutputHandler implements DataContainer {

    public static void print(String linha) {
        String mensagem = limpar(linha);
        System.out.println(output(mensagem));
    }


    // ======= M�TODOS AUXILIARES =======

    /**
     * <p>
     * Deixa todos os valores com o mesmo tipo
     * </p>
     *
     * @param valores os valores a serem normalizados
     * @return os valores normalizados
     */
    private static String normalizaTipos(List<Object> valores) {
        StringBuilder strBuilder = new StringBuilder();
        for (Object valor : valores) {
            strBuilder.append(valor);
        }
        return strBuilder.toString();
    }

    /**
     * <p>
     * Remove caracter�sticas desnecess�rias da linha
     * </p>
     *
     * @param linha linha a ser limpa
     * @return linha limpa de caracteristicas desnecess�rias
     */
    private static String limpar(String linha) {
        return linha.replace(Constants.PRINT, Constants.EMPTY_STRING)
                .replace(Constants.PONTO_E_VIRGULA, Constants.EMPTY_STRING)
                .replace(Constants.ABRE_PARENTESES, Constants.EMPTY_STRING)
                .replace(Constants.FECHA_PARENTESES, Constants.EMPTY_STRING);
    }

    /**
     * <p>
     * Pega o valor de cada parte do output
     * </p>
     *
     * @param partes as partes que cont�m os valores
     * @return os valores de cada parte
     */
    private static List<Object> getValores(String[] partes) {
        List<Object> valores = new ArrayList<>();
        for (String parte : partes) {
            Object valor = parte.trim().replace(Constants.ASPAS_SIMPLES, Constants.EMPTY_STRING);

            if (variaveis.containsKey(valor)) {
                valor = variaveis.get(valor);
            }

            valores.add(valor);
        }
        return valores;
    }

    /**
     * <p>
     * Extrai a mensagem a ser exibida
     * </p>
     *
     * @param mensagem linha que cont�m a mensagem
     * @return o output a ser exibido
     */
    private static Object output(String mensagem) {
        Object output;
        if (mensagem.startsWith(Constants.ASPAS_SIMPLES)) {
            if (mensagem.contains(MathOperator.ADD.get())) {
                String[] partes = mensagem.trim().split(MathOperator.ADD.regex());
                List<Object> valores = getValores(partes);
                output = normalizaTipos(valores);
            } else {
                output = mensagem.replace(Constants.ASPAS_SIMPLES, Constants.EMPTY_STRING);
            }
        } else if (variaveis.containsKey(mensagem)) {
            output = variaveis.get(mensagem);
        } else if (Util.isOperacaoMatematica(mensagem)) {
            output = MathOperatorHandler.avaliar(mensagem);
        } else {
            output = mensagem;
        }

        return output;
    }

}
