
package br.dastan.conexao;

import br.dastan.controle.PWSenha;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static br.dastan.util.MyConstant.FILE_CONNECTION;

/**
 *
 * @author Filipe
 */
public class SingleConnection {
    private static Connection connection = null;
    private static Properties properties = null;
    private static String driver;
    private static String url;
    private static String database;
    private static String user;
    private static String password;

    public static Connection getInstance() {
        if(connection == null) {
            loadConnection();
            try {
                System.out.println(driver);
                System.out.println(url + database);
                System.out.println(user);
                System.out.println(password);
                Class.forName(driver);
                connection = DriverManager.getConnection(url + database, user, password);
            } catch (ClassNotFoundException ex) {
                showMessageDialog(null, "Erro ao carregar as configurações da base de dados.\nLog: " +
                        ex.getMessage(), "Erro de leitura", ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (SQLException ex) {
                showMessageDialog(null, "Erro ao conectar a base de dados (SQLException).\nLog: " +
                        ex.getMessage(), "Erro", ERROR_MESSAGE);
            }
        }

        return connection;
    }

    public static boolean testInstance() {
        getInstance();

        if(connection != null) return true;
        else return false;
    }

    private static void loadConnection() {
        properties = new Properties();
        FileInputStream fis;
        PWSenha dct = new PWSenha();

        try {
            String file = FILE_CONNECTION;
            fis = new FileInputStream(file);
            properties.load(fis);
        } catch (FileNotFoundException ex) {
            showMessageDialog(null, "Erro ao carregar o arquivo de Configurações.\nLog: " +
                    ex.getMessage(), "Erro (não encontrado)", ERROR_MESSAGE);
        } catch (IOException ex) {
            showMessageDialog(null, "Erro ao carregar o arquivo de Configurações.\nLog: " +
                    ex.getMessage(), "Erro de leitura", ERROR_MESSAGE);
        }

        try {
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            database = properties.getProperty("database");
            user = properties.getProperty("user");
            password = dct.decrypt(properties.getProperty("password"));
        } catch (Exception ex) {
            showMessageDialog(null, "Erro ao carregar as propriedades.\nLog: " +
                    ex.getMessage(), "Erro", ERROR_MESSAGE);
        }
    }
}
