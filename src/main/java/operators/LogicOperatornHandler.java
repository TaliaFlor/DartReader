package operators;

import controledefluxo.ConditionalHandler;
import data.DataContainer;
import enums.LogicOperator;
import enums.RelationalOperator;
import enums.Type;

public class LogicOperatornHandler implements DataContainer {

    public static boolean logicOperators(String condicao) {
        boolean resultado;
        if (condicao.contains(LogicOperator.AND.get())) {
            String[] partes = condicao.split(LogicOperator.AND.get());
            boolean condicao1 = false;
            boolean condicao2 = false;

            if (partes[0].trim().equals("true") || partes[0].trim().equals("false")) {
                condicao1 = Boolean.parseBoolean(partes[0]);
            } else if (variaveis.containsKey(partes[0]) && tipos.get(partes[0]) == Type.BOOLEAN) {
                condicao1 = (boolean) variaveis.get(partes[0]);

            }

            if (condicao.contains(RelationalOperator.MAIOR_QUE.get() ) || condicao.contains(RelationalOperator.MENOR_QUE.get())
                    ||condicao.contains(RelationalOperator.MAIOR_IGUAL.get() ) || condicao.contains(RelationalOperator.MENOR_IGUAL.get())
                    || condicao.contains(RelationalOperator.IGUAL.get())  ||  condicao.contains(RelationalOperator.DIFERENTE.get())){

                condicao1 = RelationalOperatorHandler.relationalOperator(partes[0]);

            }



            if (partes[1].trim().equals("true") || partes[1].trim().equals("false")) {
                condicao2 = Boolean.parseBoolean(partes[1]);
            } else if (variaveis.containsKey(partes[1]) && tipos.get(partes[1]) == Type.BOOLEAN) {
                condicao2 = (boolean) variaveis.get(partes[1]);
            }
            if (condicao.contains(RelationalOperator.MAIOR_QUE.get() ) || condicao.contains(RelationalOperator.MENOR_QUE.get())
                    ||condicao.contains(RelationalOperator.MAIOR_IGUAL.get() ) || condicao.contains(RelationalOperator.MENOR_IGUAL.get())
                    || condicao.contains(RelationalOperator.IGUAL.get())  ||  condicao.contains(RelationalOperator.DIFERENTE.get())){

                condicao2 = RelationalOperatorHandler.relationalOperator(partes[1]);

            }
            if(condicao1 && condicao2){
              resultado = true;
            }else{
                resultado = false;
            }
        } else {
            String[] partes = condicao.split(LogicOperator.OR.get());
            boolean condicao1 = false;
            boolean condicao2 = false;

            if (partes[0].trim().equals("true") || partes[0].trim().equals("false")) {
                condicao1 = Boolean.parseBoolean(partes[0]);
            } else if (variaveis.containsKey(partes[0]) && tipos.get(partes[0]) == Type.BOOLEAN) {
                condicao1 = (boolean) variaveis.get(partes[0]);
            }
                if (condicao.contains(RelationalOperator.MAIOR_QUE.get() ) || condicao.contains(RelationalOperator.MENOR_QUE.get())
                        ||condicao.contains(RelationalOperator.MAIOR_IGUAL.get() ) || condicao.contains(RelationalOperator.MENOR_IGUAL.get())
                        || condicao.contains(RelationalOperator.IGUAL.get())  ||  condicao.contains(RelationalOperator.DIFERENTE.get())){

                    condicao1 = RelationalOperatorHandler.relationalOperator(partes[0]);

                }
            if (partes[1].trim().equals("true") || partes[1].trim().equals("false")) {
                condicao2 = Boolean.parseBoolean(partes[1]);
            } else if (variaveis.containsKey(partes[1]) && tipos.get(partes[1]) == Type.BOOLEAN) {
                condicao2 = (boolean) variaveis.get(partes[1]);
            }
            if (condicao.contains(RelationalOperator.MAIOR_QUE.get() ) || condicao.contains(RelationalOperator.MENOR_QUE.get())
                    ||condicao.contains(RelationalOperator.MAIOR_IGUAL.get() ) || condicao.contains(RelationalOperator.MENOR_IGUAL.get())
                    || condicao.contains(RelationalOperator.IGUAL.get())  ||  condicao.contains(RelationalOperator.DIFERENTE.get())){

                condicao2 = RelationalOperatorHandler.relationalOperator(partes[1]);

            }

            if(condicao1 || condicao2){
                resultado = true;
            }else{
                resultado = false;
            }
        }

        return  resultado;

    }


}
