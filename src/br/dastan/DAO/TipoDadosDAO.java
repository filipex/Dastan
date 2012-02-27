package br.dastan.DAO;

import br.dastan.interfaces.Conexao;
import br.dastan.persistencia.TipoDados;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.JOptionPane.*;

/*
 * @author GarHoa
 */
public class TipoDadosDAO implements Conexao<TipoDados> {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private br.dastan.conexao.Conexao conexao;
    private TipoDados tipoDados;

    public TipoDadosDAO() {
        connection = conexao.getConnection();
        tipoDados = new TipoDados();
    }

    public boolean inserir(TipoDados tab) {
        String sql = "INSERT INTO dtDados (dbanco, djava) " +
                "VALUES (?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, tab.getTpBanco());
            ps.setString(2, tab.getTpJava());

            if(ps.executeUpdate() > 0) return true;
            else return false;
        } catch(SQLException sqle) {
            showMessageDialog(null, sqle.getMessage(), "Erro ao Inserir", ERROR_MESSAGE);
            return false;
        }
    }

    public boolean excluir(TipoDados tab) {
        String sql = "DELETE FROM dtDados " +
                "WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, tab.getId());

            if(ps.executeUpdate() > 0) return true;
            else return false;
        } catch(SQLException sqle) {
            showMessageDialog(null, sqle.getMessage(), "Erro ao Excluir", ERROR_MESSAGE);
            return false;
        }
    }

    public boolean atualizar(TipoDados tab) {
        String sql = "UPDATE dtDados " +
                "SET dbanco = ?, djava = ? " +
                "WHERE id = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, tab.getTpBanco());
            ps.setString(2, tab.getTpJava());
            ps.setInt(3, tab.getId());

            if(ps.executeUpdate() > 0) return true;
            else return false;
        } catch(SQLException sqle) {
            showMessageDialog(null, sqle.getMessage(), "Erro ao Atualizar", ERROR_MESSAGE);
            return false;
        }
    }

    public List carregar() {
        List dados_tabela = new ArrayList();
        String sql = "SELECT * " +
                "FROM dtDados";

        try {
            rs = connection.createStatement().executeQuery(sql);
            while(rs.next()) {
                TipoDados tab = new TipoDados();
                tab.setId(rs.getInt("id"));
                tab.setTpBanco(rs.getString("dbanco"));
                tab.setTpJava(rs.getString("djava"));
                dados_tabela.add(tab);
            }

            return dados_tabela;
        } catch(SQLException sqle) {
            showMessageDialog(getRootFrame(), sqle.getMessage(), "Erro ao Carregar Dados", ERROR_MESSAGE);
            sqle.printStackTrace();
            return null;
        }
    }

    public TipoDados selecionarTpBanco(TipoDados tab) {
        String sql = "SELECT * " +
                "FROM dtDados " +
                "WHERE dbanco = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, tab.getTpBanco());
            rs = ps.executeQuery();
            if(rs.next()) {
                tab.setId(rs.getInt("id"));
                tab.setTpBanco(rs.getString("dbanco"));
                tab.setTpJava(rs.getString("djava"));
            }

            return tab;
        } catch (SQLException sqle) {
            showMessageDialog(getRootFrame(), sqle.getMessage(), "Erro ao Pesquisar Tipo Atributo", ERROR_MESSAGE);
            sqle.printStackTrace();
            return null;
        }
    }

    public TipoDados selecionarId(TipoDados tab) {
        String sql = "SELECT id " +
                "FROM dtDados " +
                "WHERE dbanco = ? AND djava = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, tab.getTpBanco());
            ps.setString(2, tab.getTpJava());
            rs = ps.executeQuery();

            if(rs.next()) getDados();

            return tipoDados;
        } catch (SQLException sqle) {
            showMessageDialog(getRootFrame(), sqle.getMessage(), "Erro ao Pesquisar Código do Atributo", ERROR_MESSAGE);
            sqle.printStackTrace();
            return null;
        }

    }

    private void getDados() {
        try {
            tipoDados.setId(rs.getInt("id"));
            tipoDados.setTpBanco(rs.getString("dbanco"));
            tipoDados.setTpJava(rs.getString("djava"));
        } catch (Exception e) { }
    }
}