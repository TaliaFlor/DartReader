package operators;

import data.DataContainer;
import enums.MathOperator;
import enums.Type;
import util.Util;

import java.util.Arrays;

/**
 * <p>
 * Classe reponsável por avaliar as operações matemáticas
 * </p>
 */
public class MathOperatorHandler implements DataContainer {

    public static double avaliar(String operacao) {
        double resultado = 0;

        if (operacao.contains(MathOperator.ADD.get())) {
            double[] operacoes = getValores(operacao, MathOperator.ADD);
            resultado = Arrays.stream(operacoes).sum();
        } else if (operacao.contains(MathOperator.SUB.get())) {
            double[] operacoes = getValores(operacao, MathOperator.SUB);
            for (int i = 0; i < operacoes.length; i++) {
                if (i == 0) {
                    resultado = operacoes[i];
                    continue;
                }
                resultado -= operacoes[i];
            }
        } else if (operacao.contains(MathOperator.MULT.get())) {
            double[] operacoes = getValores(operacao, MathOperator.MULT);
            for (int i = 0; i < operacoes.length; i++) {
                if (i == 0) {
                    resultado = operacoes[i];
                    continue;
                }
                resultado *= operacoes[i];
            }
        } else {
            double[] operacoes = getValores(operacao, MathOperator.DIV);
            for (int i = 0; i < operacoes.length; i++) {
                if (i == 0) {
                    resultado = operacoes[i];
                    continue;
                }
                resultado /= operacoes[i];
            }
        }

        return resultado;
    }

    private static double[] getValores(String operacao, MathOperator operador) {
        String[] partes = operacao.split(operador.regex());
        double[] operacoes = new double[partes.length];

        for (int i = 0; i < partes.length; i++) {
            if (variaveis.containsKey(partes[i]) && Util.isNumber(partes[i])) {
                operacoes[i] = (double) variaveis.get(partes[i]);
            } else {
                operacoes[i] = Double.parseDouble(partes[i]);
            }
        }

        return operacoes;
    }

}
