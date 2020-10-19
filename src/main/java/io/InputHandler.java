package io;

import enums.Type;
import file.WriterManager;

import java.util.Scanner;

/**
 * <p>
 * Classe responsávelpor lidar com a tradução da entrada de dados por parte do usuário (Comandos de entrada)
 * </p>
 */
public class InputHandler {

    private static Scanner in = new Scanner(System.in);

    /**
     * <p>
     * Traduz a recepção de input do usuário
     * </p>
     *
     * @param tipo o tipo da variável que receberá o input
     * @return o comando de input de acordo com o tipo da variável
     */
    public static Object input(Type tipo) {
        return getInput(tipo);
    }


    /**
     * <p>
     * Retorna o comando de input em Java equivalente para o tipo da variável
     * </p>
     *
     * @param tipo o tipo da variável
     * @return o comando de input equivalente para o tipo
     */
    private static Object getInput(Type tipo) {
        switch (tipo) {
            case INT:
                return in.nextInt();
            case NUM:
            case DOUBLE:
                return in.nextDouble();
            case BOOLEAN:
                return in.nextBoolean();
            default:
                return in.nextLine();
        }
    }

}
