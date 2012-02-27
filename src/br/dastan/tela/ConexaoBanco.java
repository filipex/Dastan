
package br.dastan.tela;

import br.dastan.DAO.ConexaoDAO;
import br.dastan.conexao.Conexao;
import br.dastan.persistencia.ConexaoDados;
import br.dastan.controle.Controles;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author GarHoa
 */
public class ConexaoBanco extends javax.swing.JDialog {
    private ConexaoDados conexao_dados;
    private Conexao conexao;
    private ConexaoDAO daoConexao;
    private Controles control;
    private Principal principal = new Principal();
    
    public ConexaoBanco() {
        control = new Controles();
        daoConexao = new ConexaoDAO();

        initComponents();
        getConexaoProperties();

        this.setModal(true);
        this.setLocationRelativeTo(null);
        btGravar.setEnabled(false);
        keyReleased(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnConexao = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfDriver = new javax.swing.JTextField();
        tfUrl = new javax.swing.JTextField();
        tfUser = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        tfBanco = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        btGravar = new javax.swing.JButton();
        btTestarConexao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conexão com o Banco de Dados");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnConexao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Driver:");

        jLabel2.setText("URL:");

        jLabel3.setText("Usuário:");

        jLabel4.setText("Senha:");

        tfDriver.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ConexaoBanco.this.keyReleased(evt);
            }
        });

        tfUrl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ConexaoBanco.this.keyReleased(evt);
            }
        });

        tfUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ConexaoBanco.this.keyReleased(evt);
            }
        });

        tfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ConexaoBanco.this.keyReleased(evt);
            }
        });

        jLabel5.setText("Tabela:");

        tfBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ConexaoBanco.this.keyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnConexaoLayout = new javax.swing.GroupLayout(pnConexao);
        pnConexao.setLayout(pnConexaoLayout);
        pnConexaoLayout.setHorizontalGroup(
            pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnConexaoLayout.createSequentialGroup()
                        .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(25, 25, 25)
                        .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDriver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(tfUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(tfBanco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
                    .addGroup(pnConexaoLayout.createSequentialGroup()
                        .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnConexaoLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(tfPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                            .addGroup(pnConexaoLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(tfUser, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnConexaoLayout.setVerticalGroup(
            pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConexaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnConexaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btGravar.setText("Gravar");
        btGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGravarActionPerformed(evt);
            }
        });

        btTestarConexao.setText("Testar Conexão");
        btTestarConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTestarConexaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnConexao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btTestarConexao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnConexao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btGravar)
                    .addComponent(btTestarConexao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(btGravar.isEnabled()) {
            int opcao = showOptionDialog(this, "Deseja salvar?", "Confirmação", 0, 3, null,
                new String[]{"Sim", "Não"}, "Sim");

            if(opcao == YES_OPTION) {
                this.dispose();
                new Principal().setVisible(true);
            }
        } else this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void keyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyReleased
        if(!control.getTextField(pnConexao)) btTestarConexao.setEnabled(true);
        else btTestarConexao.setEnabled(false);

        btGravar.setEnabled(false);
    }//GEN-LAST:event_keyReleased

    private void btTestarConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTestarConexaoActionPerformed
        conexao_dados = new ConexaoDados();
        String senha = new String(tfPassword.getPassword());

        conexao_dados.setDriver(tfDriver.getText());
        conexao_dados.setUrl(tfUrl.getText());
        conexao_dados.setTabela(tfBanco.getText());
        conexao_dados.setUsuario(tfUser.getText());
        conexao_dados.setSenha(senha);
        
        conexao = new Conexao(conexao_dados);
        
        if(conexao.getTestConnection()) {
            btGravar.setEnabled(true);
            showMessageDialog(this, "Conectado com sucesso!", "Conexão com o BD", INFORMATION_MESSAGE);
        } else btGravar.setEnabled(false);
    }//GEN-LAST:event_btTestarConexaoActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
        conexao_dados = new ConexaoDados();
        String senha = new String(tfPassword.getPassword());

        conexao_dados.setDriver(tfDriver.getText());
        conexao_dados.setUrl(tfUrl.getText());
        conexao_dados.setTabela(tfBanco.getText());
        conexao_dados.setUsuario(tfUser.getText());        
        conexao_dados.setSenha(senha);

        if(daoConexao.atualizar(conexao_dados)) {
            getConexaoProperties();
            this.dispose();
            principal.setVisible(true);
        }       
    }//GEN-LAST:event_btGravarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        if(btGravar.isEnabled()) {
            int opcao = showOptionDialog(this, "Deseja salvar?", "Confirmação", 0, 3, null,
                new String[]{"Sim", "Não"}, "Sim");

                if(opcao == YES_OPTION) daoConexao.atualizar(conexao_dados);
                else {
                    if(!control.getTextField(pnConexao)) {
                        conexao = new Conexao();
                        if(conexao.getTestConnection()) {
                            this.dispose();
                            new Principal().setVisible(true);
                        } else System.exit(0);
                    }
                }
        } else System.exit(0);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void getConexaoProperties() {
        if(conexao.getTestConnection()) {
            Properties properties = new Properties();
            
            try {                
                FileInputStream fis = new FileInputStream("conexao.properties");
                properties.load(fis);
            } catch (FileNotFoundException e) {
            } catch (IOException e) { }

            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String banco = properties.getProperty("database");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            tfDriver.setText(driver);
            tfUrl.setText(url);
            tfBanco.setText(banco);
            tfUser.setText(user);
            tfPassword.setText(password);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConexaoBanco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGravar;
    private javax.swing.JButton btTestarConexao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pnConexao;
    private javax.swing.JTextField tfBanco;
    private javax.swing.JTextField tfDriver;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUrl;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables

}
