package operators;

import data.DataContainer;
import enums.LogicOperator;
import enums.Type;
import util.Util;

/**
 * <p>
 * Classe reponsável por avaliar as operações lógicas
 * </p>
 */
public class LogicOperatorHandler implements DataContainer {

    public static boolean avaliar(String operacao) {
        boolean resultado;

        if (operacao.contains(LogicOperator.AND.get())) {
            resultado = true;
            boolean[] valores = getValores(operacao, LogicOperator.AND.get());
            for (boolean item : valores) {
                if (!item) {
                    resultado = false;
                    break;
                }
            }
        } else {
            resultado = false;
            boolean[] valores = getValores(operacao, LogicOperator.OR.get());
            for (boolean item : valores) {
                if (item) {
                    resultado = true;
                    break;
                }
            }
        }

        return resultado;
    }

    /**
     * <p>
     * Retorna os valores da condição em boleano
     * </p>
     *
     * @param condicao a condição a ser analisada
     * @param operador operador logico da expressão
     * @return os valores da condição em boleano
     */
    private static boolean[] getValores(String condicao, String operador) {
        String[] partes = condicao.split(operador);
        boolean[] valores = new boolean[partes.length];

        for (int i = 0; i < partes.length; i++) {
            if (Util.isBoolean(partes[i])) {
                valores[i] = Boolean.parseBoolean(partes[i]);
            } else if (variaveis.containsKey(partes[i]) && tipos.get(partes[i]) == Type.BOOLEAN) {
                valores[i] = (boolean) variaveis.get(partes[i]);
            }

            if (Util.isOperacaoRelacional(condicao)) {
                valores[i] = RelationalOperatorHandler.avaliar(partes[i]);
            }
        }

        return valores;
    }


}
