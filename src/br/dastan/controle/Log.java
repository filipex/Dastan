
package br.dastan.controle;

import br.dastan.exception.MyIOException;
import java.io.FileWriter;
import java.io.IOException;

import static br.dastan.util.MyConstant.EXTENSAO_FILE_LOG;

/**
 *
 * @author GarHoa
 */
public class Log {
    private GeradorData gd;

    public Log() {
        gd = new GeradorData();
    }

    public void gerarLog(String dados) throws MyIOException {
        try {
            String arquivo = "";
            FileWriter fw = new FileWriter("C://Dastan/Log" + gd.getDateStr() + "." + EXTENSAO_FILE_LOG, true);

            arquivo = gd.getDateFormat() + " - " + gd.getTimeFormat() + " : " + dados + "\n";

            fw.write(arquivo);
            fw.close();
        } catch (IOException e) {
            throw new MyIOException(e.getMessage());
        }
    }
}
