package interpreter;

import controledefluxo.ConditionalHandler;
import data.DataContainer;
import file.WriterManager;
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
                linha.startsWith("boolean") || linha.startsWith("string") || linha.startsWith("var") || linha.contains("=");
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
            WriterManager.pularLinha();
            return;
        }

        if (linha.startsWith("import") || linha.startsWith("void")) {
            return;
        }

        if (linha.startsWith("print(")) {
            OutputHandler.print(linha);
        } else if (hasVariavel(linha)) {
            VariableHandler.definirVariavel(linha);
        }else if (linha.contains("if")){
            ConditionalHandler.condicional(linha);
        }
    }

}