
package br.dastan.conexao;

import br.dastan.DAO.ConexaoDAO;
import br.dastan.persistencia.ConexaoDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author GarHoa
 */
public class Conexao {
    private static Connection conn;
    private static ConexaoDados conexao_dados;
    private static ConexaoDAO daoConexao;
    
    public Conexao() {
        this.conexao_dados = new ConexaoDados();
        this.daoConexao = new ConexaoDAO();
        this.conexao_dados = daoConexao.carregarConfigConexao();
    }

    public Conexao(ConexaoDados conexao_dados) {
        this.conexao_dados = new ConexaoDados();
        this.daoConexao = new ConexaoDAO();
        this.conexao_dados = conexao_dados;
    }

    public static Connection getConnection() {
        if(conn == null) {
            try {
                System.out.println("'" + conexao_dados.getDriver() + "'");
                Class.forName(conexao_dados.getDriver());
                conn = DriverManager.getConnection(conexao_dados.getUrl() + conexao_dados.getTabela(),
                        conexao_dados.getUsuario(), conexao_dados.getSenha());
            } catch (ClassNotFoundException e) {
                showMessageDialog(null, "Erro ao efetuar conexão.\nLog: " + e.getMessage(), "Conexão", ERROR_MESSAGE);
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
                showMessageDialog(null, "Erro ao efetuar conexão (SQL).\nLog: " + e.getMessage(), "Conexão", ERROR_MESSAGE);
                return null;
            }
        }

        return conn;
    }

    public static boolean getTestConnection() {
        getConnection();
        
        if(conn != null) return true;
        else return false;
    }
}