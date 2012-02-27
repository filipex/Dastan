
package br.dastan.DAO;

import br.dastan.controle.PWSenha;
import br.dastan.controle.GerarProperties;
import java.io.FileInputStream;
import br.dastan.persistencia.ConexaoDados;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author GarHoa
 */
public class ConexaoDAO {
    private Properties properties;
    private FileInputStream arquivo_entrada;
    private FileOutputStream arquivo_saida;
    private ConexaoDados conexao;
    private PWSenha dct = new PWSenha();

    public ConexaoDAO() { }

    public boolean atualizar(br.dastan.persistencia.ConexaoDados object) {
        try {
            properties = new Properties();
            arquivo_saida = new FileOutputStream("conexao.properties");
        } catch(FileNotFoundException e) {
            GerarProperties gerar_properties = new GerarProperties();
            arquivo_saida = gerar_properties.gerarArquivoConexao();
        }

        try {
            properties.setProperty("driver", object.getDriver());
            properties.setProperty("url", object.getUrl());
            properties.setProperty("database", object.getTabela());
            properties.setProperty("user", object.getUsuario());
            properties.setProperty("password", dct.encrypt(object.getSenha()));
            properties.store(arquivo_saida, "Arquivo de Conexao com o Banco de Dados");

            return true;
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage(), "Inserir", ERROR_MESSAGE);
            return false;
        }
    }

    public ConexaoDados carregarConfigConexao() {
        conexao = new ConexaoDados();
                
        try {
            properties = new Properties();
            arquivo_entrada = new FileInputStream("conexao.properties");
            properties.load(arquivo_entrada);
        } catch (FileNotFoundException enfe) {
            showMessageDialog(null, "Erro ao carregar arquivo de Configuração. Arquivo não encontrado!", "Conexão", ERROR_MESSAGE);
            GerarProperties gerar_properties = new GerarProperties();
            gerar_properties.gerarArquivoConexao();
            return null;
        } catch (IOException ioe) {
            showMessageDialog(null, "Erro ao carregar arquivo de Configuração. Erro de leitura!", "Conexão", ERROR_MESSAGE);
            return null;
        }

        try {
            arquivo_entrada = new FileInputStream("conexao.properties");
            properties.load(arquivo_entrada);
            conexao.setDriver(properties.getProperty("driver"));
            conexao.setUrl(properties.getProperty("url"));
            conexao.setTabela(properties.getProperty("database"));
            conexao.setUsuario(properties.getProperty("user"));
            conexao.setSenha(dct.decrypt(properties.getProperty("password")));
        } catch (Exception e) {
            showMessageDialog(null, "Erro ao carregar dados do arquivo de Configuração.\n" +
                    e.getMessage(), "Carregar Configuração de Conexão", ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
        
        return conexao;
    }   
}