package operators;

import data.DataContainer;
import enums.RelationalOperator;
import enums.Type;

public class RelationalOperatorHandler implements DataContainer {


    public static boolean relationalOperator(String condicao){
        boolean resultado;
        if(condicao.contains(RelationalOperator.MAIOR_QUE.get())){
            String [] partes = condicao.split(RelationalOperator.MAIOR_QUE.get());
            double condicao1, condicao2;

            if(variaveis.containsKey(partes[0]) && (tipos.get(partes[0])== Type.INT ||
                    tipos.get(partes[0])== Type.DOUBLE || tipos.get(partes[0])== Type.NUM )) {
                condicao1 = (double) variaveis.get(partes[0]);
            }else{
                condicao1 = Double.parseDouble(partes[0]);
            }

            if(variaveis.containsKey(partes[1]) && (tipos.get(partes[1])== Type.INT ||
                    tipos.get(partes[1])== Type.DOUBLE || tipos.get(partes[1])== Type.NUM )) {
                condicao2 = (double) variaveis.get(partes[1]);
            }else{
                condicao2 = Double.parseDouble(partes[1]);
            }

            if(condicao1> condicao2){
                resultado =true;
            }else{
                resultado = false;
            }
        }else if(condicao.contains(RelationalOperator.MENOR_QUE.get())) {
            String [] partes = condicao.split(RelationalOperator.MENOR_QUE.get());
            double condicao1, condicao2;

            if(variaveis.containsKey(partes[0]) && (tipos.get(partes[0])== Type.INT ||
                    tipos.get(partes[0])== Type.DOUBLE || tipos.get(partes[0])== Type.NUM )) {
                condicao1 = (double) variaveis.get(partes[0]);
            }else{
                condicao1 = Double.parseDouble(partes[0]);
            }

            if(variaveis.containsKey(partes[1]) && (tipos.get(partes[1])== Type.INT ||
                    tipos.get(partes[1])== Type.DOUBLE || tipos.get(partes[1])== Type.NUM )) {
                condicao2 = (double) variaveis.get(partes[1]);
            }else{
                condicao2 = Double.parseDouble(partes[1]);
            }

            if(condicao1 < condicao2){
                resultado = true;
            }else{
                resultado = false;
            }

        }else if(condicao.contains(RelationalOperator.MAIOR_IGUAL.get())) {
            String [] partes = condicao.split(RelationalOperator.MAIOR_IGUAL.get());
            double condicao1, condicao2;

            if(variaveis.containsKey(partes[0]) && (tipos.get(partes[0])== Type.INT ||
                    tipos.get(partes[0])== Type.DOUBLE || tipos.get(partes[0])== Type.NUM )) {
                condicao1 = (double) variaveis.get(partes[0]);
            }else{
                condicao1 = Double.parseDouble(partes[0]);
            }

            if(variaveis.containsKey(partes[1]) && (tipos.get(partes[1])== Type.INT ||
                    tipos.get(partes[1])== Type.DOUBLE || tipos.get(partes[1])== Type.NUM )) {
                condicao2 = (double) variaveis.get(partes[1]);
            }else{
                condicao2 = Double.parseDouble(partes[1]);
            }

            if(condicao1 >= condicao2){
                resultado =true;
            }else{
                resultado = false;
            }

        }else if(condicao.contains(RelationalOperator.MENOR_IGUAL.get())) {
            String [] partes = condicao.split(RelationalOperator.MENOR_IGUAL.get());
            double condicao1, condicao2;

            if(variaveis.containsKey(partes[0]) && (tipos.get(partes[0])== Type.INT ||
                    tipos.get(partes[0])== Type.DOUBLE || tipos.get(partes[0])== Type.NUM )) {
                condicao1 = (double) variaveis.get(partes[0]);
            }else{
                condicao1 = Double.parseDouble(partes[0]);
            }

            if(variaveis.containsKey(partes[1]) && (tipos.get(partes[1])== Type.INT ||
                    tipos.get(partes[1])== Type.DOUBLE || tipos.get(partes[1])== Type.NUM )) {
                condicao2 = (double) variaveis.get(partes[1]);
            }else{
                condicao2 = Double.parseDouble(partes[1]);
            }

            if(condicao1 <= condicao2){
                resultado = true;
            }else{
                resultado = false;
            }

        }else if(condicao.contains(RelationalOperator.IGUAL.get())) {
            String [] partes = condicao.split(RelationalOperator.IGUAL.get());
            double condicao1, condicao2;

            if(variaveis.containsKey(partes[0]) && (tipos.get(partes[0])== Type.INT ||
                    tipos.get(partes[0])== Type.DOUBLE || tipos.get(partes[0])== Type.NUM )) {
                condicao1 = (double) variaveis.get(partes[0]);
            }else{
                condicao1 = Double.parseDouble(partes[0]);
            }

            if(variaveis.containsKey(partes[1]) && (tipos.get(partes[1])== Type.INT ||
                    tipos.get(partes[1])== Type.DOUBLE || tipos.get(partes[1])== Type.NUM )) {
                condicao2 = (double) variaveis.get(partes[1]);
            }else{
                condicao2 = Double.parseDouble(partes[1]);
            }

            if(condicao1 == condicao2){
                resultado = true;
            }else{
                resultado = false;
            }
        }else{

            String [] partes = condicao.split(RelationalOperator.DIFERENTE.get());
            double condicao1, condicao2;

            if(variaveis.containsKey(partes[0]) && (tipos.get(partes[0])== Type.INT ||
                    tipos.get(partes[0])== Type.DOUBLE || tipos.get(partes[0])== Type.NUM )) {
                condicao1 = (double) variaveis.get(partes[0]);
            }else{
                condicao1 = Double.parseDouble(partes[0]);
            }

            if(variaveis.containsKey(partes[1]) && (tipos.get(partes[1])== Type.INT ||
                    tipos.get(partes[1])== Type.DOUBLE || tipos.get(partes[1])== Type.NUM )) {
                condicao2 = (double) variaveis.get(partes[1]);
            }else{
                condicao2 = Double.parseDouble(partes[1]);
            }

            if(condicao1 != condicao2){
                resultado = true;
            }else{
                resultado = false;
            }

        }
        return resultado;
    }
}
