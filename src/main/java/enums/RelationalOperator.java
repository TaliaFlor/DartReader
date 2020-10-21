package enums;

/**
 * <p>
 * Representa os operadores relacionais
 * </p>
 */
public enum RelationalOperator {
    MAIOR_QUE(">"),
    MENOR_QUE("<"),
    MAIOR_IGUAL(">="),
    MENOR_IGUAL("<="),
    IGUAL("=="),
    DIFERENTE("!=");


    private final String valor;


    RelationalOperator(String valor) {
        this.valor = valor;
    }


    public String get() {
        return valor;
    }

}
