package interpreter;

import controlflow.ConditionalHandler;
import data.DataContainer;
import global.Constants;
import global.GlobalVariables;
import io.OutputHandler;
import util.Util;
import variable.VariableHandler;

/**
 * <p>
 * Classe responsável por gerenciar a interpredação das linhas de código Dart
 * </p>
 */
public class InterpreterManager implements DataContainer {
    private static final String IMPORT = "import";
    private static final String VOID = "void";


    /**
     * <p>
     * Interpreta as linhas do arquivo
     * </p>
     */
    public static void interpretar() {
        linhas.stream()
                .map(String::trim)
                .forEach(InterpreterManager::interpretar);
    }

    /**
     * <p>
     * Interpreta cada linha de acordo com suas características
     * </p>
     *
     * @param linha linha a ser interpretada
     */
    private static void interpretar(String linha) {
        if (linha.isEmpty() || linha.startsWith(IMPORT) || linha.startsWith(VOID)) {
            return;
        }

        if (GlobalVariables.ENCONTROU_IF && !GlobalVariables.LER_CHAVES) {
            if (linha.startsWith(Constants.FECHA_CHAVES)) {
                if (linha.contains(Constants.IF)) {
                    ConditionalHandler.interpretar(linha);
                } else {    // Para 'else' e ifs únicos
                    GlobalVariables.ENCONTROU_IF = false;
                }
            }
        } else {
            if (linha.startsWith(Constants.PRINT)) {
                OutputHandler.print(linha);
            } else if (Util.isVariavel(linha)) {
                VariableHandler.definir(linha);
            } else if (linha.contains(Constants.IF)) {
                ConditionalHandler.interpretar(linha);
            }
        }
    }

}