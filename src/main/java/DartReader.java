import file.ReaderManager;
import file.WriterManager;
import interpreter.InterpreterManager;

/**
 * <p>
 * Classe principal do projeto, respons�vel por rodar os m�todos
 * que fazem a leitura, tradu��o e escrita dos dados
 * </p>
 */
public class DartReader {

    //TODO BUG: O resultado �:  + result

    public static void main(String[] args) {
        ReaderManager.lerArquivo();
        InterpreterManager.interpretarLinhas();
        
    }

}
