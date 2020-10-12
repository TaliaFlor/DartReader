import file.ReaderManager;
import file.WriterManager;
import translator.TranslatorManager;

/**
 * <p>
 * Classe principal do projeto, respons�vel por rodar os m�todos que fazem a leitura, tradu��o e escrita dos dados
 * </p>
 */
public class DartReader {

    public static void main(String[] args) {
        ReaderManager.lerArquivo();
        TranslatorManager.traduzirLinhas();
        WriterManager.escreverArquivo();
    }

}
