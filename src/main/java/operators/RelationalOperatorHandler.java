package operators;

import data.DataContainer;
import enums.RelationalOperator;
import enums.Type;

public class RelationalOperatorHandler implements DataContainer {


    public static boolean relationalOperator(String condicao) {
        condicao = condicao.replace("{", "").replace("}", "")
                .replace("if", "").replace("else", "")
                .replace("(", "").replace(")", "");

        boolean resultado;
        if (condicao.contains(RelationalOperator.MAIOR_QUE.get())) {
            String[] partes = condicao.split(RelationalOperator.MAIOR_QUE.get());
            double condicao1, condicao2;

            if (variaveis.containsKey(partes[0].trim()) && (tipos.get(partes[0].trim()) == Type.INT ||
                    tipos.get(partes[0].trim()) == Type.DOUBLE || tipos.get(partes[0].trim()) == Type.NUM)) {
                condicao1 = Double.parseDouble(String.valueOf(variaveis.get(partes[0].trim())));
            } else {
                condicao1 = Double.parseDouble(partes[0].trim());
            }

            if (variaveis.containsKey(partes[1].trim()) && (tipos.get(partes[1].trim()) == Type.INT ||
                    tipos.get(partes[1].trim()) == Type.DOUBLE || tipos.get(partes[1].trim()) == Type.NUM)) {
                condicao2 = Double.parseDouble(String.valueOf(variaveis.get(partes[1].trim())));
            } else {
                condicao2 = Double.parseDouble(partes[1].trim());
            }

            resultado = condicao1 > condicao2;
        } else if (condicao.contains(RelationalOperator.MENOR_QUE.get())) {
            String[] partes = condicao.split(RelationalOperator.MENOR_QUE.get());
            double condicao1, condicao2;

            if (variaveis.containsKey(partes[0].trim()) && (tipos.get(partes[0].trim()) == Type.INT ||
                    tipos.get(partes[0].trim()) == Type.DOUBLE || tipos.get(partes[0].trim()) == Type.NUM)) {
                condicao1 = Double.parseDouble(String.valueOf(variaveis.get(partes[0].trim())));
            } else {
                condicao1 = Double.parseDouble(partes[0].trim());
            }

            if (variaveis.containsKey(partes[1].trim()) && (tipos.get(partes[1].trim()) == Type.INT ||
                    tipos.get(partes[1].trim()) == Type.DOUBLE || tipos.get(partes[1].trim()) == Type.NUM)) {
                condicao2 = Double.parseDouble(String.valueOf(variaveis.get(partes[1].trim())));
            } else {
                condicao2 = Double.parseDouble(partes[1].trim());
            }

            resultado = condicao1 < condicao2;

        } else if (condicao.contains(RelationalOperator.MAIOR_IGUAL.get())) {
            String[] partes = condicao.split(RelationalOperator.MAIOR_IGUAL.get());
            double condicao1, condicao2;

            if (variaveis.containsKey(partes[0].trim()) && (tipos.get(partes[0].trim()) == Type.INT ||
                    tipos.get(partes[0].trim()) == Type.DOUBLE || tipos.get(partes[0].trim()) == Type.NUM)) {
                condicao1 = Double.parseDouble(String.valueOf(variaveis.get(partes[0].trim())));
            } else {
                condicao1 = Double.parseDouble(partes[0].trim());
            }

            if (variaveis.containsKey(partes[1].trim()) && (tipos.get(partes[1].trim()) == Type.INT ||
                    tipos.get(partes[1].trim()) == Type.DOUBLE || tipos.get(partes[1].trim()) == Type.NUM)) {
                condicao2 = Double.parseDouble(String.valueOf(variaveis.get(partes[1].trim())));
            } else {
                condicao2 = Double.parseDouble(partes[1].trim());
            }

            resultado = condicao1 >= condicao2;

        } else if (condicao.contains(RelationalOperator.MENOR_IGUAL.get())) {
            String[] partes = condicao.split(RelationalOperator.MENOR_IGUAL.get());
            double condicao1, condicao2;

            if (variaveis.containsKey(partes[0].trim()) && (tipos.get(partes[0].trim()) == Type.INT ||
                    tipos.get(partes[0].trim()) == Type.DOUBLE || tipos.get(partes[0].trim()) == Type.NUM)) {
                condicao1 = Double.parseDouble(String.valueOf(variaveis.get(partes[0].trim())));
            } else {
                condicao1 = Double.parseDouble(partes[0].trim());
            }

            if (variaveis.containsKey(partes[1].trim()) && (tipos.get(partes[1].trim()) == Type.INT ||
                    tipos.get(partes[1].trim()) == Type.DOUBLE || tipos.get(partes[1].trim()) == Type.NUM)) {
                condicao2 = Double.parseDouble(String.valueOf(variaveis.get(partes[1].trim())));
            } else {
                condicao2 = Double.parseDouble(partes[1].trim());
            }

            resultado = condicao1 <= condicao2;

        } else if (condicao.contains(RelationalOperator.IGUAL.get())) {
            String[] partes = condicao.split(RelationalOperator.IGUAL.get());
            double condicao1, condicao2;

            if (variaveis.containsKey(partes[0].trim()) && (tipos.get(partes[0].trim()) == Type.INT ||
                    tipos.get(partes[0].trim()) == Type.DOUBLE || tipos.get(partes[0].trim()) == Type.NUM)) {
                condicao1 = Double.parseDouble(String.valueOf(variaveis.get(partes[0].trim())));
            } else {
                condicao1 = Double.parseDouble(partes[0].trim());
            }

            if (variaveis.containsKey(partes[1].trim()) && (tipos.get(partes[1].trim()) == Type.INT ||
                    tipos.get(partes[1].trim()) == Type.DOUBLE || tipos.get(partes[1].trim()) == Type.NUM)) {
                condicao2 = Double.parseDouble(String.valueOf(variaveis.get(partes[1].trim())));
            } else {
                condicao2 = Double.parseDouble(partes[1].trim());
            }

            resultado = condicao1 == condicao2;
        } else {

            String[] partes = condicao.split(RelationalOperator.DIFERENTE.get());
            double condicao1, condicao2;

            if (variaveis.containsKey(partes[0].trim()) && (tipos.get(partes[0].trim()) == Type.INT ||
                    tipos.get(partes[0].trim()) == Type.DOUBLE || tipos.get(partes[0].trim()) == Type.NUM)) {
                condicao1 = Double.parseDouble(String.valueOf(variaveis.get(partes[0].trim())));
            } else {
                condicao1 = Double.parseDouble(partes[0].trim());
            }

            if (variaveis.containsKey(partes[1].trim()) && (tipos.get(partes[1].trim()) == Type.INT ||
                    tipos.get(partes[1].trim()) == Type.DOUBLE || tipos.get(partes[1].trim()) == Type.NUM)) {
                condicao2 = Double.parseDouble(String.valueOf(variaveis.get(partes[1].trim())));
            } else {
                condicao2 = Double.parseDouble(partes[1].trim());
            }

            resultado = condicao1 != condicao2;

        }
        return resultado;
    }
}
