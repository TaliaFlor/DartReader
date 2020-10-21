package io;

import enums.Type;

import java.util.Scanner;

/**
 * <p>
 * Classe responsávelpor lidar com a interpretação da entrada de dados por parte do usuário (Comandos de entrada)
 * </p>
 */
public class InputHandler {

    private static final Scanner in = new Scanner(System.in);

    /**
     * <p>
     * Interpreta a recepção de input do usuário
     * </p>
     *
     * @param tipo o tipo da variável que receberá o input
     * @return o comando de input de acordo com o tipo da variável
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
