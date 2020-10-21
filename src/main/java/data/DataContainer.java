package data;

import enums.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Guarda os dados da interpretação em Runtime e os disponibiliza para o uso das outras classes
 * </p>
 */
public interface DataContainer {

    /**
     * <p>
     * Contém as linhas lidas do arquivo de entrada
     * </p>
     */
    List<String> linhas = new ArrayList<>();

    /**
     * <p>
     * Contém os tipos das variáveis
     * </p>
     */
    Map<String, Type> tipos = new HashMap<>();

    /**
     * <p>
     * Contém os valores das variáveis
     * </p>
     */
    Map<String, Object> variaveis = new HashMap<>();

}
