package enums;

/**
 * <p>
 * Representa os operadores matemáticos
 * </p>
 */
public enum MathOperator {
    ADD("+", "\\+"),
    SUB("-", "\\-"),
    MULT("*", "\\*"),
    DIV("/", "\\/");


    private final String valor;
    private final String regex;     // Valor do operador em formato regex-safe


    MathOperator(String valor, String regex) {
        this.valor = valor;
        this.regex = regex;
    }


    public String get() {
        return valor;
    }

    public String regex() {
        return regex;
    }

}
