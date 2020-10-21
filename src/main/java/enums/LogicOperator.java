package enums;

/**
 * <p>
 * Representa os operadores l�gicos
 * </p>
 */
public enum LogicOperator {
    AND("&&"),
    OR("||");


    private final String valor;


    LogicOperator(String valor) {
        this.valor = valor;
    }


    public String get() {
        return valor;
    }

}
