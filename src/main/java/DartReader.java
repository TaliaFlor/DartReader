import file.ReaderManager;
import interpreter.InterpreterManager;

/**
 * <p>
 * Classe principal do projeto, respons�vel por rodar os m�todos
 * que fazem a leitura, tradu��o e escrita dos dados
 * </p>
 */
public class DartReader {

    //TODO BUG: O resultado �:  + result ---> if est� entrando em tudo

    public static void main(String[] args) {
        ReaderManager.lerArquivo();
        InterpreterManager.interpretarLinhas();
    }

}
