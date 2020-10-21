package util;

import data.DataContainer;
import enums.LogicOperator;
import enums.MathOperator;
import enums.RelationalOperator;
import enums.Type;
import global.Constants;

/**
 * <p>
 * Possui métodos utilitários que podem ser usados em toda a aplicação
 * </p>
 */
public class Util implements DataContainer {
    private static final String ATRIBUICAO = "=";


    public static boolean isInt(String line) {
        return line.startsWith(Type.INT.get()) || line.contains(Type.INT.get());
    }

    public static boolean isDouble(String line) {
        return line.startsWith(Type.DOUBLE.get()) || line.contains(Type.DOUBLE.get());
    }

    public static boolean isNum(String line) {
        return line.startsWith(Type.NUM.get()) || line.contains(Type.NUM.get());
    }

    public static boolean isNumber(String valor) {
        return tipos.get(valor) == Type.INT || tipos.get(valor) == Type.DOUBLE || tipos.get(valor) == Type.NUM;
    }

    public static boolean isBoolean(String valor) {
        return valor.startsWith(Type.BOOLEAN.get()) || valor.contains(Type.BOOLEAN.get())
                || valor.equals(Constants.TRUE) || valor.equals(Constants.FALSE);
    }

    public static boolean isString(String line) {
        return line.startsWith(Type.STRING.get()) || line.contains(Type.STRING.get())
                || line.startsWith(Constants.ASPAS_SIMPLES);
    }

    public static boolean isOperacaoLogica(String condicao) {
        return condicao.contains(LogicOperator.AND.get())
                || condicao.contains(LogicOperator.OR.get());
    }

    public static boolean isOperacaoRelacional(String condicao) {
        return condicao.contains(RelationalOperator.MAIOR_QUE.get())        // Só precisa destas três opções para testar
                || condicao.contains(RelationalOperator.MENOR_QUE.get())    // esse método porque todos os outros operadores
                || condicao.contains(RelationalOperator.IGUAL.get());       // contém algum simbolo destes
    }

    public static boolean isOperacaoMatematica(String linha) {
        return (linha.contains(MathOperator.ADD.get()) && !linha.contains(Constants.ASPAS_SIMPLES))
                || linha.contains(MathOperator.SUB.get()) || linha.contains(MathOperator.MULT.get())
                || linha.contains(MathOperator.DIV.get());
    }

    public static boolean isVariavel(String linha) {
        return linha.startsWith(Type.INT.get()) || linha.startsWith(Type.DOUBLE.get()) || linha.startsWith(Type.NUM.get()) ||
                linha.startsWith(Type.BOOLEAN.get()) || linha.startsWith(Type.STRING.get()) || linha.startsWith(Type.VAR.get())
                || (!linha.contains(RelationalOperator.IGUAL.get()) && linha.contains(ATRIBUICAO));
    }

}
