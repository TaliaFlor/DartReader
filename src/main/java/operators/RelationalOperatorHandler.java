package operators;

import data.DataContainer;
import enums.RelationalOperator;
import global.Constants;
import util.Util;

public class RelationalOperatorHandler implements DataContainer {

    private static final String ELSE = "else";


    public static boolean avaliar(String operacao) {
        operacao = limpar(operacao);

        RelationalOperator operador;
        if (operacao.contains(RelationalOperator.MAIOR_QUE.get())) {
            operador = RelationalOperator.MAIOR_QUE;
        } else if (operacao.contains(RelationalOperator.MENOR_QUE.get())) {
            operador = RelationalOperator.MENOR_QUE;
        } else if (operacao.contains(RelationalOperator.MAIOR_IGUAL.get())) {
            operador = RelationalOperator.MAIOR_IGUAL;
        } else if (operacao.contains(RelationalOperator.MENOR_IGUAL.get())) {
            operador = RelationalOperator.MENOR_IGUAL;
        } else if (operacao.contains(RelationalOperator.IGUAL.get())) {
            operador = RelationalOperator.IGUAL;
        } else {
            operador = RelationalOperator.DIFERENTE;
        }

        return avaliar(operacao, operador);
    }

    private static String limpar(String operacao) {
        return operacao.replace(Constants.IF, Constants.EMPTY_STRING)
                .replace(ELSE, Constants.EMPTY_STRING)
                .replace(Constants.ABRE_CHAVES, Constants.EMPTY_STRING)
                .replace(Constants.FECHA_CHAVES, Constants.EMPTY_STRING)
                .replace(Constants.ABRE_PARENTESES, Constants.EMPTY_STRING)
                .replace(Constants.FECHA_PARENTESES, Constants.EMPTY_STRING);
    }

    private static double[] getValores(String operacao, RelationalOperator operador) {
        String[] partes = operacao.split(operador.get());
        double[] condicoes = new double[partes.length];

        for (int i = 0; i < partes.length; i++) {
            String parte = partes[i].trim();
            if (variaveis.containsKey(parte) && Util.isNumber(parte)) {
                condicoes[i] = Double.parseDouble(String.valueOf(variaveis.get(parte)));
            } else {
                condicoes[i] = Double.parseDouble(parte);
            }
        }
        return condicoes;
    }

    private static boolean avaliar(String operacao, RelationalOperator operador) {
        double[] condicoes = getValores(operacao, operador);

        double base = 0;
        for (int i = 0; i < condicoes.length; i++) {
            if (i == 0) {
                base = condicoes[i];
            } else if (quebraRegra(operador, base, condicoes[i])) {
                return false;
            } else {
                base = condicoes[i];
            }
        }
        return true;
    }

    /**
     * <p>
     * Verifica se o caso dado quebra a regra de operadores relacionais
     * </p>
     *
     * @param operador o operador da operação a ser verificada
     * @param base     o valor base
     * @param valor    o valor comparado contra a base
     * @return true se quebra a regra, false se não quebra
     */
    private static boolean quebraRegra(RelationalOperator operador, double base, double valor) {
        switch (operador) {
            case MAIOR_QUE:
                return valor >= base;
            case MENOR_QUE:
                return valor <= base;
            case MAIOR_IGUAL:
                return valor > base;
            case MENOR_IGUAL:
                return valor < base;
            case IGUAL:
                return valor != base;
            default:
                return valor == base;       // case DIFERENTE
        }
    }

}
