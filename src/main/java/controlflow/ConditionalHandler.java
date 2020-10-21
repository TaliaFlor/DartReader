package controlflow;

import data.DataContainer;
import global.Constants;
import global.GlobalVariables;
import operators.LogicOperatorHandler;
import operators.RelationalOperatorHandler;
import util.Util;

/**
 * <p>
 * Classe responsável por interpretar o comando de controle de fluxo condicional 'if'
 * </p>
 */
public class ConditionalHandler implements DataContainer {

    /**
     * <p>
     * Interpreta linha com condicional
     * </p>
     *
     * @param linha a linha que contém condicional a ser interpretada
     */
    public static void interpretar(String linha) {
        resetVariaveisGlobais();

        String condicao = limpaLinha(linha);

        if (Util.isOperacaoLogica(condicao)) {
            GlobalVariables.LER_CHAVES = LogicOperatorHandler.avaliar(condicao);
        } else if (Util.isOperacaoRelacional(condicao)) {
            GlobalVariables.LER_CHAVES = RelationalOperatorHandler.avaliar(condicao);
        } else if (Util.isBoolean(condicao)) {
            GlobalVariables.LER_CHAVES = Boolean.parseBoolean(condicao);
        } else {
            GlobalVariables.LER_CHAVES = (boolean) variaveis.get(condicao);
        }

    }

    private static void resetVariaveisGlobais() {
        GlobalVariables.LER_CHAVES = false;
        GlobalVariables.ENCONTROU_IF = true;
    }

    private static String limpaLinha(String linha) {
        return linha.replace(Constants.IF, Constants.EMPTY_STRING)
                .replace(Constants.ABRE_PARENTESES, Constants.EMPTY_STRING)
                .replace(Constants.FECHA_PARENTESES, Constants.EMPTY_STRING)
                .replace(Constants.ABRE_CHAVES, Constants.EMPTY_STRING)
                .trim();
    }
}
