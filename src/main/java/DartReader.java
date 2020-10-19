import file.ReaderManager;
import file.WriterManager;
import interpreter.InterpreterManager;

/**
 * <p>
 * Classe principal do projeto, responsável por rodar os métodos
 * que fazem a leitura, tradução e escrita dos dados
 * </p>
 */
public class DartReader {

    //TODO BUG: O resultado é:  + result

    public static void main(String[] args) {
        ReaderManager.lerArquivo();
        InterpreterManager.interpretarLinhas();
        
    }

}
