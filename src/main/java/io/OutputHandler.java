package io;

import data.DataContainer;
import file.WriterManager;
import util.Util;

/**
 * <p>
 * Classe respons�velpor lidar com a tradu��o da sa�da de dados (Comandos de sa�da)
 * </p>
 */
public class OutputHandler implements DataContainer {
    private static final String EMPTY_STRING = "";
    private static final String ASPAS_SIMPLES = "'";
    private static final String ASPAS_DUPLAS = "\"";


    /**
     * <p>
     * Traduz a sa�da de dados de volta para o usu�rio
     * </p>
     *
     * @param linha linha a ser traduzida
     */
    public static void print(String linha) {
        linha = limparLinha(linha);
        Object output = getOutput(linha);
        WriterManager.addLinha("System.out.println(" + output + ");");
    }


    // ======= M�TODOS AUXILIARES =======

    /**
     * <p>
     * Limpa a linha de caracteres e informa��es desnecess�rias
     * </p>
     *
     * @param linha linha a ser limpa
     * @return linha limpa
     */
    private static String limparLinha(String linha) {
        return linha.replace("print", EMPTY_STRING)
                .replace(";", EMPTY_STRING)
                .replace("(", EMPTY_STRING)
                .replace(")", EMPTY_STRING);
    }

    /**
     * <p>
     * Extrai a mensagem a ser exibida
     * </p>
     *
     * @param linha linha que cont�m a mensagem
     * @return a mensagem a ser exibida
     */
    private static Object getOutput(String linha) {
        Object output;
        if (linha.startsWith(ASPAS_SIMPLES)) {
            output = linha.replace(ASPAS_SIMPLES, ASPAS_DUPLAS);
        } else if (nomesPorTipo.containsKey(linha)) {
            output = Util.getValor(linha);
        } else {
            output = linha;
        }
        return output;
    }

}
