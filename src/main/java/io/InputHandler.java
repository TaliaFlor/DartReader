package io;

import enums.Type;

import java.util.Scanner;

/**
 * <p>
 * Classe respons�velpor lidar com a interpreta��o da entrada de dados por parte do usu�rio (Comandos de entrada)
 * </p>
 */
public class InputHandler {

    private static final Scanner in = new Scanner(System.in);

    /**
     * <p>
     * Interpreta a recep��o de input do usu�rio
     * </p>
     *
     * @param tipo o tipo da vari�vel que receber� o input
     * @return o comando de input de acordo com o tipo da vari�vel
     */
    public static Object input(Type tipo) {
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
