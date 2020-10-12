package translator;

import data.DataContainer;
import file.WriterManager;
import io.OutputHandler;
import variable.VariableHandler;

/**
 * <p>
 * Classe respons�vel por traduzir as linhas de c�digo de Dart para Java
 * </p>
 */
public class TranslatorManager implements DataContainer {

    /**
     * <p>
     * Traduz as linhas do arquivo lido de Dart para Java
     * </p>
     */
    public static void traduzirLinhas() {
        linhas.stream()
                .map(String::trim)
                .forEach(TranslatorManager::traduzirLinha);
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
                linha.startsWith("boolean") || linha.startsWith("string") || linha.startsWith("var");
    }

    /**
     * <p>
     * Traduz cada linha de acordo com suas caracter�sticas
     * </p>
     *
     * @param linha linha a ser traduzida
     */
    private static void traduzirLinha(String linha) {
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
        } else {
            WriterManager.addLinha(linha);
        }
    }

}