import file.ReaderManager;
import interpreter.InterpreterManager;

/**
 * <p>
 * Classe principal do projeto, responsável por rodar os métodos
 * que fazem a leitura e interpretação dos dados
 * </p>
 */
public class DartReader {

    public static void main(String[] args) {
        ReaderManager.ler();
        InterpreterManager.interpretar();
    }

}
