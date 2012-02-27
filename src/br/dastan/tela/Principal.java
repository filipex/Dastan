
package br.dastan.tela;

import br.dastan.controle.Controles;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author GarHoa
 */
public class Principal extends javax.swing.JFrame {
    private Controles control = new Controles();

    public Principal() {        
        initComponents();

        bgOpcoes.add(rbPublic);
        bgOpcoes.add(rbPrivate);
        bgOpcoes.add(rbProtected);
        rbPrivate.setSelected(true);
        control.setCheckBox(pnGerarMetodos);
        btParametros.setToolTipText("Parâmetros");
        btAtributosBD.setToolTipText("Atributos Conexão");
        btConfigConexao.setToolTipText("Configurar Conexão");
        btImportarSQL.setToolTipText("Importar SQL");
        btSair.setToolTipText("Sair");

        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgOpcoes = new javax.swing.ButtonGroup();
        pnTipoDados = new javax.swing.JPanel();
        rbPublic = new javax.swing.JRadioButton();
        rbPrivate = new javax.swing.JRadioButton();
        rbProtected = new javax.swing.JRadioButton();
        tbMenu = new javax.swing.JToolBar();
        btParametros = new javax.swing.JButton();
        btAtributosBD = new javax.swing.JButton();
        btConfigConexao = new javax.swing.JButton();
        btImportarSQL = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        pnGerarMetodos = new javax.swing.JPanel();
        cbGetterAndSetter = new javax.swing.JCheckBox();
        cbConstrutor = new javax.swing.JCheckBox();
        cbEquals = new javax.swing.JCheckBox();
        cbHashCode = new javax.swing.JCheckBox();
        btCancelar = new javax.swing.JButton();
        btGerar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnConfigurar = new javax.swing.JMenu();
        miConfigConexao = new javax.swing.JMenuItem();
        miAtributosBD = new javax.swing.JMenuItem();
        miParametros = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miImportarSQL = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dastan 1.0");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnTipoDados.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo dos dados"));

        rbPublic.setText("public");

        rbPrivate.setText("private");

        rbProtected.setText("protected");

        javax.swing.GroupLayout pnTipoDadosLayout = new javax.swing.GroupLayout(pnTipoDados);
        pnTipoDados.setLayout(pnTipoDadosLayout);
        pnTipoDadosLayout.setHorizontalGroup(
            pnTipoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTipoDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnTipoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbPublic)
                    .addComponent(rbProtected)
                    .addComponent(rbPrivate))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        pnTipoDadosLayout.setVerticalGroup(
            pnTipoDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTipoDadosLayout.createSequentialGroup()
                .addComponent(rbPublic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbPrivate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbProtected))
        );

        tbMenu.setRollover(true);

        btParametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/dastan/icone/tools.png"))); // NOI18N
        btParametros.setFocusable(false);
        btParametros.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btParametros.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.actionPerformed(evt);
            }
        });
        tbMenu.add(btParametros);

        btAtributosBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/dastan/icone/harddisk.png"))); // NOI18N
        btAtributosBD.setFocusable(false);
        btAtributosBD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAtributosBD.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAtributosBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.actionPerformed(evt);
            }
        });
        tbMenu.add(btAtributosBD);

        btConfigConexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/dastan/icone/globe.png"))); // NOI18N
        btConfigConexao.setFocusable(false);
        btConfigConexao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btConfigConexao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btConfigConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.actionPerformed(evt);
            }
        });
        tbMenu.add(btConfigConexao);

        btImportarSQL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/dastan/icone/cd.png"))); // NOI18N
        btImportarSQL.setFocusable(false);
        btImportarSQL.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btImportarSQL.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btImportarSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.actionPerformed(evt);
            }
        });
        tbMenu.add(btImportarSQL);

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/dastan/icone/power_blue.png"))); // NOI18N
        btSair.setFocusable(false);
        btSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSair.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.actionPerformed(evt);
            }
        });
        tbMenu.add(btSair);

        pnGerarMetodos.setBorder(javax.swing.BorderFactory.createTitledBorder("Gerar"));

        cbGetterAndSetter.setText("Getter and Setter");

        cbConstrutor.setText("Construtor");

        cbEquals.setText("Método Equals()");

        cbHashCode.setText("Método hashCode()");

        javax.swing.GroupLayout pnGerarMetodosLayout = new javax.swing.GroupLayout(pnGerarMetodos);
        pnGerarMetodos.setLayout(pnGerarMetodosLayout);
        pnGerarMetodosLayout.setHorizontalGroup(
            pnGerarMetodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGerarMetodosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnGerarMetodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbConstrutor)
                    .addComponent(cbGetterAndSetter)
                    .addComponent(cbEquals)
                    .addComponent(cbHashCode))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        pnGerarMetodosLayout.setVerticalGroup(
            pnGerarMetodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGerarMetodosLayout.createSequentialGroup()
                .addComponent(cbConstrutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbGetterAndSetter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEquals)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbHashCode)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btGerar.setText("Gerar");
        btGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarActionPerformed(evt);
            }
        });

        jMenu1.setText("Sistema");

        mnConfigurar.setText("Configurar");

        miConfigConexao.setText("Conexão com Banco de Dados");
        miConfigConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.actionPerformed(evt);
            }
        });
        mnConfigurar.add(miConfigConexao);

        miAtributosBD.setText("Atributos do Banco de Dados");
        miAtributosBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.actionPerformed(evt);
            }
        });
        mnConfigurar.add(miAtributosBD);

        jMenu1.add(mnConfigurar);

        miParametros.setText("Parâmetros");
        jMenu1.add(miParametros);
        jMenu1.add(jSeparator1);

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.actionPerformed(evt);
            }
        });
        jMenu1.add(miSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Utilitário");

        miImportarSQL.setText("Importar SQL");
        miImportarSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Principal.this.actionPerformed(evt);
            }
        });
        jMenu2.add(miImportarSQL);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTipoDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnGerarMetodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(btGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTipoDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnGerarMetodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btGerar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btGerarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        fecharSistema();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fecharSistema();
    }//GEN-LAST:event_formWindowClosing

    private void actionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionPerformed
        if(evt.getSource() == miImportarSQL || evt.getSource() == btImportarSQL) new ImportarSQL(control.getRadioButton(pnTipoDados), cbConstrutor.isSelected(),
                cbGetterAndSetter.isSelected(), cbEquals.isSelected(), cbHashCode.isSelected()).setVisible(true);
        else if(evt.getSource() == miConfigConexao || evt.getSource() == btConfigConexao) new ConexaoBanco().setVisible(true);
        else if(evt.getSource() == miAtributosBD || evt.getSource() == btAtributosBD) new TabelaDados().setVisible(true);
        else if(evt.getSource() == miSair || evt.getSource() == btSair) fecharSistema();

    }//GEN-LAST:event_actionPerformed
   
    private void fecharSistema() {
        int opcao = showOptionDialog(this, "Deseja realmente sair?", "Confirmação", 0, 3, null,
                new String[]{"Sim", "Não"}, "Sim");

        if(opcao == YES_OPTION) System.exit(0);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgOpcoes;
    private javax.swing.JButton btAtributosBD;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfigConexao;
    private javax.swing.JButton btGerar;
    private javax.swing.JButton btImportarSQL;
    private javax.swing.JButton btParametros;
    private javax.swing.JButton btSair;
    private javax.swing.JCheckBox cbConstrutor;
    private javax.swing.JCheckBox cbEquals;
    private javax.swing.JCheckBox cbGetterAndSetter;
    private javax.swing.JCheckBox cbHashCode;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem miAtributosBD;
    private javax.swing.JMenuItem miConfigConexao;
    private javax.swing.JMenuItem miImportarSQL;
    private javax.swing.JMenuItem miParametros;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenu mnConfigurar;
    private javax.swing.JPanel pnGerarMetodos;
    private javax.swing.JPanel pnTipoDados;
    private javax.swing.JRadioButton rbPrivate;
    private javax.swing.JRadioButton rbProtected;
    private javax.swing.JRadioButton rbPublic;
    private javax.swing.JToolBar tbMenu;
    // End of variables declaration//GEN-END:variables

}
