import file.ReaderManager;
import interpreter.InterpreterManager;

/**
 * <p>
 * Classe principal do projeto, respons�vel por rodar os m�todos
 * que fazem a leitura e interpreta��o dos dados
 * </p>
 */
public class DartReader {

    public static void main(String[] args) {
        ReaderManager.ler();
        InterpreterManager.interpretar();
    }

}
