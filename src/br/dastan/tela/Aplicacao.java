
package br.dastan.tela;

import br.dastan.conexao.Conexao;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author GarHoa
 */
public class Aplicacao {
    private static Conexao conexao = new Conexao();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) { }

        //if(conexao.getTestConnection()) new Principal().setVisible(true);
        //else new ConexaoBanco().setVisible(true);

        new Principal().setVisible(true);
    }
}
