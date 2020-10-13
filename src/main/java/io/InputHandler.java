package io;

import enums.Type;
import file.WriterManager;

/**
 * <p>
 * Classe respons�velpor lidar com a tradu��o da entrada de dados por parte do usu�rio (Comandos de entrada)
 * </p>
 */
public class InputHandler {

    private static boolean scannerInicializado = false;


    /**
     * <p>
     * Traduz a recep��o de input do usu�rio
     * </p>
     *
     * @param tipo o tipo da vari�vel que receber� o input
     * @return o comando de input de acordo com o tipo da vari�vel
     */
    public static String input(Type tipo) {
        WriterManager.addImport("java.util.Scanner");

        if (!scannerInicializado) {
            WriterManager.addLinha("Scanner in = new Scanner(System.in);");
            scannerInicializado = true;
        }

        return getInput(tipo);
    }


    /**
     * <p>
     * Retorna o comando de input em Java equivalente para o tipo da vari�vel
     * </p>
     *
     * @param tipo o tipo da vari�vel
     * @return o comando de input equivalente para o tipo
     */
    private static String getInput(Type tipo) {
        switch (tipo) {
            case INT:
                return "in.nextInt();";
            case NUM:
            case DOUBLE:
                return "in.nextDouble();";
            case BOOLEAN:
                return "in.nextBoolean();";
            default:
                return "in.nextLine();";
        }
    }

}
