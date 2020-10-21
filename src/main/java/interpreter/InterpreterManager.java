package interpreter;

import controledefluxo.ConditionalHandler;
import controledefluxo.WhileHandler;
import data.DataContainer;
import data.GlobalVariables;
import io.OutputHandler;
import variable.VariableHandler;

/**
 * <p>
 * Classe responsável por traduzir as linhas de código de Dart para Java
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


    // ======= MÉTODOS AUXILIARES =======

    /**
     * <p>
     * Determina se a linha está declarando uma variável
     * </p>
     *
     * @param linha linha a ser examinada
     * @return caso a linha esteja declarando uma variável ou não
     */
    private static boolean hasVariavel(String linha) {
        return linha.startsWith("int") || linha.startsWith("double") || linha.startsWith("num") ||
                linha.startsWith("boolean") || linha.startsWith("string") || linha.startsWith("var")
                || (!linha.contains("==") && linha.contains("="));
    }

    /**
     * <p>
     * Traduz cada linha de acordo com suas características
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

        if (GlobalVariables.ENCONTROU_IF) {
            if (linha.trim().startsWith("}")) {
                if (linha.contains("if")) {
                    ConditionalHandler.condicional(linha);
                } else {    // Para 'else' e ifs únicos
                    GlobalVariables.ENCONTROU_IF = false;
                }
            } else if (GlobalVariables.LER_CHAVES) {
                if (linha.startsWith("print(")) {
                    OutputHandler.print(linha);
                } else if (hasVariavel(linha)) {
                    VariableHandler.definirVariavel(linha);
                }
            }
        } else {
            if (linha.startsWith("print(")) {
                OutputHandler.print(linha);
            } else if (hasVariavel(linha)) {
                VariableHandler.definirVariavel(linha);
            } else if (linha.contains("if")) {
                GlobalVariables.ENCONTROU_IF = true;
                ConditionalHandler.condicional(linha);
            }
        }
        
        if (GlobalVariables.ENCONTROU_WHILE) {
            if (linha.trim().startsWith("while(")) {
                if (linha.contains("){")) {
                	WhileHandler.condicaoWhile(linha);
                } else {    
                    GlobalVariables.ENCONTROU_WHILE = false;
                }
            } else if (GlobalVariables.LER_CHAVES) {
                if (linha.startsWith("print(")) {
                    OutputHandler.print(linha);
                } else if (hasVariavel(linha)) {
                    VariableHandler.definirVariavel(linha);
                }
            }
        } else {
            if (linha.startsWith("print(")) {
                OutputHandler.print(linha);
            } else if (hasVariavel(linha)) {
                VariableHandler.definirVariavel(linha);
            } else if (linha.contains("while")) {
                GlobalVariables.ENCONTROU_WHILE = true;
                WhileHandler.condicaoWhile(linha);
            }
        }
    }

}