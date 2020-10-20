package interpreter;

import controledefluxo.ConditionalHandler;
import data.DataContainer;
import io.OutputHandler;
import variable.VariableHandler;

/**
 * <p>
 * Classe respons�vel por traduzir as linhas de c�digo de Dart para Java
 * </p>
 */
public class InterpreterManager implements DataContainer {

    /**
     * <p>
     * Traduz as linhas do arquivo lido de Dart para Java
     * </p>
     */
    public static void interpretarLinhas() {
        linhas.stream()
                .map(String::trim)
                .forEach(InterpreterManager::interpretarLinha);
    }


    // ======= M�TODOS AUXILIARES =======

    /**
     * <p>
     * Determina se a linha est� declarando uma vari�vel
     * </p>
     *
     * @param linha linha a ser examinada
     * @return caso a linha esteja declarando uma vari�vel ou n�o
     */
    private static boolean hasVariavel(String linha) {
        return linha.startsWith("int") || linha.startsWith("double") || linha.startsWith("num") ||
                linha.startsWith("boolean") || linha.startsWith("string") || linha.startsWith("var")
                || (!linha.contains("==") && linha.contains("="));
    }

    /**
     * <p>
     * Traduz cada linha de acordo com suas caracter�sticas
     * </p>
     *
     * @param linha linha a ser traduzida
     */
    private static void interpretarLinha(String linha) {
        if (linha.isEmpty()) {
            return;
        }

        if (linha.startsWith("import") || linha.startsWith("void")) {
            return;
        }

//        if (linha.contains("if")) {
//            if (GlobalVariables.PRIMEIRO_IF) {
//                GlobalVariables.PRIMEIRO_IF = false;
//                GlobalVariables.ENCONTROU_IF = true;
//
//                ConditionalHandler.condicional(linha);
//            }
//        } else (linha.contains("else") && !GlobalVariables.LER_CHAVES) {
//            ConditionalHandler.condicional(linha);
//        }

//        if (!GlobalVariables.ENCONTROU_IF || (GlobalVariables.ENCONTROU_IF && GlobalVariables.LER_CHAVES)) {
        if (linha.startsWith("print(")) {
            OutputHandler.print(linha);
        } else if (hasVariavel(linha)) {
            VariableHandler.definirVariavel(linha);
        } else if (linha.contains("if")) {
            ConditionalHandler.condicional(linha);
        }
//        } else if (linha.contains("if") || linha.contains("else")) {
//            if (GlobalVariables.PRIMEIRO_IF) {
//                GlobalVariables.PRIMEIRO_IF = false;
//                GlobalVariables.ENCONTROU_IF = true;
//
//                ConditionalHandler.condicional(linha);
//            }

//
//            if (!GlobalVariables.ENCONTROU_IF) {
//                GlobalVariables.ENCONTROU_IF = true;
//
//                ConditionalHandler.condicional(linha);
//            } else if (GlobalVariables.ENCONTROU_IF && GlobalVariables.LER_CHAVES) {
//                if (linha.startsWith("print(")) {
//                    OutputHandler.print(linha);
//                } else if (hasVariavel(linha)) {
//                    VariableHandler.definirVariavel(linha);
//                }
//            }

    }

}