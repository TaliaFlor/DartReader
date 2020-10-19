package enums;

public enum MathOperator {

    ADD("+"),
    SUB("-"),
    MULT("*"),
    DIV("/");

    private final String operador;


    MathOperator(String operador){

        this.operador= operador;
    }

    public String get() {
        return operador;
    }


}
