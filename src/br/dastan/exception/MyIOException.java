
package br.dastan.exception;

import br.dastan.controle.Log;
import java.io.IOException;

/**
 *
 * @author GarHoa
 */
public class MyIOException extends IOException {

    public MyIOException(String msg) throws MyIOException {
        super("Erro: " + msg);
        //gravarLog("Exceção de Leitura e Escrita : " + msg);
    }

    private void gravarLog(String msg) throws MyIOException {
        Log log = new Log();
        log.gerarLog(msg);
    }
}
