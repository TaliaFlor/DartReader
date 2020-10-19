package operators;

import data.DataContainer;
import enums.MathOperator;
import enums.Type;

public class MathematicalOperatorHandler implements DataContainer {


    public static double mathOperator(String operacao) {
        double resultado;
        if (operacao.contains(MathOperator.ADD.get())) {
            String[] partes = operacao.split("\\+");    // MathOperator.ADD.get()
            double operacao1, operacao2;

            if (variaveis.containsKey(partes[0]) && (tipos.get(partes[0]) == Type.INT || tipos.get(partes[0]) == Type.DOUBLE
                    || tipos.get(partes[0]) == Type.NUM)) {

                operacao1 = (double) variaveis.get(partes[0]);

            } else {
                operacao1 = Double.parseDouble(partes[0]);

            }
            if (variaveis.containsKey(partes[1]) && (tipos.get(partes[1]) == Type.INT || tipos.get(partes[1]) == Type.DOUBLE
                    || tipos.get(partes[1]) == Type.NUM)) {

                operacao2 = (double) variaveis.get(partes[1]);

            } else {
                operacao2 = Double.parseDouble(partes[1]);

            }
            resultado = operacao1 + operacao2;

        } else if (operacao.contains(MathOperator.SUB.get())) {
            String[] partes = operacao.split("\\-"); //MathOperator.SUB.get()
            double operacao1, operacao2;

            if (variaveis.containsKey(partes[0]) && (tipos.get(partes[0]) == Type.INT || tipos.get(partes[0]) == Type.DOUBLE
                    || tipos.get(partes[0]) == Type.NUM)) {

                operacao1 = (double) variaveis.get(partes[0]);

            } else {
                operacao1 = Double.parseDouble(partes[0]);

            }
            if (variaveis.containsKey(partes[1]) && (tipos.get(partes[1]) == Type.INT || tipos.get(partes[1]) == Type.DOUBLE
                    || tipos.get(partes[1]) == Type.NUM)) {

                operacao2 = (double) variaveis.get(partes[1]);

            } else {
                operacao2 = Double.parseDouble(partes[1]);

            }
            resultado = operacao1 - operacao2;
        } else if (operacao.contains(MathOperator.MULT.get())) {
            String[] partes = operacao.split("\\*"); //MathOperator.MULT.get()
            double operacao1, operacao2;

            if (variaveis.containsKey(partes[0]) && (tipos.get(partes[0]) == Type.INT || tipos.get(partes[0]) == Type.DOUBLE
                    || tipos.get(partes[0]) == Type.NUM)) {

                operacao1 = (double) variaveis.get(partes[0]);

            } else {
                operacao1 = Double.parseDouble(partes[0]);

            }
            if (variaveis.containsKey(partes[1]) && (tipos.get(partes[1]) == Type.INT || tipos.get(partes[1]) == Type.DOUBLE
                    || tipos.get(partes[1]) == Type.NUM)) {

                operacao2 = (double) variaveis.get(partes[1]);

            } else {
                operacao2 = Double.parseDouble(partes[1]);

            }
            resultado = operacao1 * operacao2;
        } else {
            String[] partes = operacao.split("\\/"); //MathOperator.DIV.get()
            double operacao1, operacao2;

            if (variaveis.containsKey(partes[0]) && (tipos.get(partes[0]) == Type.INT || tipos.get(partes[0]) == Type.DOUBLE
                    || tipos.get(partes[0]) == Type.NUM)) {

                operacao1 = (double) variaveis.get(partes[0]);

            } else {
                operacao1 = Double.parseDouble(partes[0]);

            }
            if (variaveis.containsKey(partes[1]) && (tipos.get(partes[1]) == Type.INT || tipos.get(partes[1]) == Type.DOUBLE
                    || tipos.get(partes[1]) == Type.NUM)) {

                operacao2 = (double) variaveis.get(partes[1]);

            } else {
                operacao2 = Double.parseDouble(partes[1]);

            }
            resultado = operacao1 / operacao2;
        }
        return resultado;
    }
}
