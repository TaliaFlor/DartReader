package controledefluxo;

import data.DataContainer;
import data.GlobalVariables;
import enums.LogicOperator;
import enums.MathOperator;
import enums.RelationalOperator;
import enums.Type;
import operators.LogicOperatornHandler;
import operators.MathematicalOperatorHandler;
import operators.RelationalOperatorHandler;

public class ConditionalHandler implements DataContainer {


    public static void condicional(String linha){
        GlobalVariables.LER_CHAVES = false;

        String condicao = linha.replace("if", "").replace("(", "")
                .replace(")","").replace("{","");

        if(condicao.contains(LogicOperator.AND.get() ) || condicao.contains(LogicOperator.OR.get() )  ){
           GlobalVariables.LER_CHAVES = LogicOperatornHandler.logicOperators(condicao);
        }else if (condicao.contains(RelationalOperator.MAIOR_QUE.get() ) || condicao.contains(RelationalOperator.MENOR_QUE.get())
                ||condicao.contains(RelationalOperator.MAIOR_IGUAL.get() ) || condicao.contains(RelationalOperator.MENOR_IGUAL.get())
                || condicao.contains(RelationalOperator.IGUAL.get())  ||  condicao.contains(RelationalOperator.DIFERENTE.get())){
            GlobalVariables.LER_CHAVES = RelationalOperatorHandler.relationalOperator(condicao);
        }else if (condicao.trim().equals("true") || condicao.trim().equals("false")){
            GlobalVariables.LER_CHAVES = Boolean.parseBoolean(condicao);
        }else{
            GlobalVariables.LER_CHAVES = (boolean) variaveis.get(condicao);
        }

    }
}
