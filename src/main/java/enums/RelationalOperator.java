package enums;

public enum RelationalOperator {

    MAIOR_QUE(">"),
    MENOR_QUE("<"),
    MAIOR_IGUAL(">="),
    MENOR_IGUAL("<="),
    IGUAL("=="),
    DIFERENTE("!=");

    private final String operador;


    RelationalOperator(String operador) {

        this.operador = operador;
    }

    public String get() {
        return operador;
    }


}
