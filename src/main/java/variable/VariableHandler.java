package variable;

import data.DataContainer;
import enums.MathOperator;
import enums.Type;
import io.InputHandler;
import operators.MathematicalOperatorHandler;
import util.Util;

/**
 * <p>
 * Classe reponsável por traduzir a definição das variáveis
 * </p>
 */
public class VariableHandler implements DataContainer {

    private static final String EMPTY_STRING = "";


    /**
     * <p>
     * Defini uma variável de acordo co seu tipo
     * </p>
     *
     * @param line linha que contém a variável
     */
    public static void definirVariavel(String line) {
        Type tipo;
        if (variaveis.containsKey(line.split("=")[0].trim())) {
            tipo = tipos.get(line.split("=")[0].trim());
        } else {
            if (Util.isInt(line)) {
                tipo = Type.INT;
            } else if (Util.isDouble(line) || Util.isNum(line)) {
                tipo = Type.DOUBLE;
            } else if (Util.isBoolean(line)) {
                tipo = Type.BOOLEAN;
            } else if (Util.isString(line)) {
                tipo = Type.STRING;
            } else {
                tipo = Type.VAR;
            }
        }
        writeVariavel(line, tipo);
    }


    // ===== MÉTODOS AUXILIARES =====

    /**
     * <p>
     * Divide a linha em duas partes: a primeira é o nome da variável e a segunda é seu valor
     * </p>
     *
     * @param line a linha a ser dividida
     * @return as partes da variável divididas
     */
    private static String[] getPartes(String line) {
        for (Type tipo : Type.values()) {
            line = line.replaceFirst(tipo.dart(), EMPTY_STRING);
        }

        return line.replace(";", EMPTY_STRING)
                .replace(" ", EMPTY_STRING)
                .replace("'", "\"")
                .split("=");
    }

    /**
     * <p>
     * Retorna o tipo verdadeiro da variável. Para ser usado com variáveis do tipo VAR
     * </p>
     *
     * @param valor o valor da variável
     * @return o tipo da variável
     */
    private static Type getTrueType(String valor) {
        Type type;
        if (tipos.containsKey(valor)) {   // Se está recebendo o valor de uma variável, seu tipo é igual o da variável
            type = tipos.get(valor);
        } else if (Util.isString(valor)) {
            type = Type.STRING;
        } else if (Util.isBoolean(valor)) {
            type = Type.BOOLEAN;
        } else {
            type = Type.DOUBLE;
        }
        return type;
    }

    /**
     * <p>
     * Reserva a forma equivalente como a declaração da variável deve ser escrita em Java
     * </p>
     *
     * @param line a linha que contém a variável
     * @param tipo o tipo da variável
     */
    private static void writeVariavel(String line, Type tipo) {
        String[] partes = getPartes(line);
        String nome = partes[0];
        Object valor = null;

        if (tipo == Type.VAR && partes.length > 1) {
            tipo = getTrueType(partes[1]);
        }

        if (partes.length > 1 && partes[1].contains("stdin.readLineSync()")) {   // Adiciona linha que recebe o input do usuário
            valor = InputHandler.input(tipo);

        } else if (partes.length > 1) {
            valor = getValor(partes[1], tipo);
        }

        tipos.put(nome, tipo);
        variaveis.put(nome, valor);
    }

    private static Object getValor(String valor, Type tipo) {
        Object retorno;
        if (variaveis.containsKey(valor)) {
            retorno = variaveis.get(valor);
        } else if ((valor.contains(MathOperator.ADD.get()) && !valor.contains("'")) || valor.contains(MathOperator.SUB.get())
                || valor.contains(MathOperator.MULT.get()) || valor.contains(MathOperator.DIV.get())) {
            retorno = MathematicalOperatorHandler.mathOperator(valor);
        } else if (tipo == Type.STRING) {
            retorno = valor;
        } else if (tipo == Type.BOOLEAN) {
            retorno = Boolean.parseBoolean(valor);
        } else {
            retorno = Double.parseDouble(valor);
        }

        return retorno;
    }
}
