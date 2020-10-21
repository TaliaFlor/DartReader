package enums;

/**
 * <p>
 * Representa os tipos das variaveis em Dart
 * </p>
 */
public enum Type {
    INT("int"),
    DOUBLE("double"),
    NUM("num"),
    STRING("string"),
    BOOLEAN("boolean"),
    VAR("var");


    private final String valor;


    Type(String valor) {
        this.valor = valor;
    }


    public String get() {
        return valor;
    }

}
