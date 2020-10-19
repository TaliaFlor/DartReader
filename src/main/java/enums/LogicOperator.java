package enums;

public enum LogicOperator {

    AND("&&"),
    OR("||");

    private final String operador;


    LogicOperator(String operador){

        this.operador= operador;
    }

    public String get() {
        return operador;
    }


}
