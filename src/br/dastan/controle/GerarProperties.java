
package br.dastan.controle;

import java.io.FileOutputStream;
import java.io.FileWriter;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author GarHoa
 */
public class GerarProperties {
    private static final String EXTENSAO = "properties";
    private FileWriter arquivo;
    private FileOutputStream arquivo_saida;

    public GerarProperties() { }

    public FileOutputStream gerarArquivoConexao() {
        try {
            arquivo = new FileWriter("conexao." + EXTENSAO, true);
            arquivo.close();

            arquivo_saida = new FileOutputStream("conexao.properties");
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage(), "Gerar Arquivo de Conexão", ERROR_MESSAGE);
        }

        return arquivo_saida;
    }
}
