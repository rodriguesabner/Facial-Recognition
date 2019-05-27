package com.kingaspx.dados;

import com.kingaspx.util.ConectaBanco;
import com.kingaspx.capture.ControlPerson;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Data extends javax.swing.JDialog {

    ConectaBanco conecta = new ConectaBanco();
    ControlPerson cod = new ControlPerson();

    public Data(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cod.preencherTabela("SELECT * FROM person ORDER BY id", tabela);
    }

    public Data() {
        initComponents();
        cod.preencherTabela("SELECT * FROM person ORDER BY id", tabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        botaoexcluir = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        txt_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_office = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_fb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_insta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_linkedin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_github = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        botaoexcluir.setText("Excluir");
        botaoexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoexcluirActionPerformed(evt);
            }
        });
        jPopupMenu1.add(botaoexcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 158, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabela.setFillsViewportHeight(true);
        tabela.setShowHorizontalLines(false);
        tabela.setShowVerticalLines(false);
        tabela.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabelaFocusGained(evt);
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 380, 420));

        txt_search.setForeground(new java.awt.Color(169, 169, 169));
        txt_search.setText("Search here...");
        txt_search.setBorder(null);
        txt_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_searchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_searchFocusLost(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 680, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 680, 10));

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 152, 193)));
        jPanel2.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 320, 20));

        jLabel2.setText("Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txt_office.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 152, 193)));
        jPanel2.add(txt_office, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 320, 20));

        jLabel3.setText("Office");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(200, 204, 208));
        jLabel12.setText("Info");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setText("Facebook");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txt_fb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 152, 193)));
        jPanel2.add(txt_fb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 320, 20));

        jLabel5.setText("Instagram");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        txt_insta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 152, 193)));
        jPanel2.add(txt_insta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 320, 20));

        jLabel6.setText("Linkedin");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        txt_linkedin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 152, 193)));
        jPanel2.add(txt_linkedin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 320, 20));

        jLabel7.setText("Github");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        txt_github.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 152, 193)));
        jPanel2.add(txt_github, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 320, 20));

        jLabel8.setText("Phone");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txt_phone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(89, 152, 193)));
        jPanel2.add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 320, 20));

        jButton2.setBackground(new java.awt.Color(87, 198, 124));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 320, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 340, 420));

        jButton1.setBackground(new java.awt.Color(213, 83, 83));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_15px_1.png"))); // NOI18N
        jButton1.setToolTipText("Close");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 480));

        setSize(new java.awt.Dimension(750, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusGained
        txt_search.setText("");
        txt_search.setForeground(new java.awt.Color(32, 32, 32));
    }//GEN-LAST:event_txt_searchFocusGained

    private void txt_searchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchFocusLost

    private void tabelaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaFocusGained
        txt_search.setForeground(new java.awt.Color(169, 169, 169));
        txt_search.setText("Search here...");
    }//GEN-LAST:event_tabelaFocusGained

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        cod.preencherTabela("SELECT * FROM person WHERE first_name LIKE '%" + txt_search.getText() + "%' OR last_name LIKE '%" + txt_search.getText() + "%' OR office LIKE '%" + txt_search.getText() + "%' ORDER BY id", tabela);
    }//GEN-LAST:event_txt_searchKeyReleased

    private void tabelaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseReleased
        if (evt.isPopupTrigger()) {//Se o mouse foi clicado com o botão de PopupMenu default do sistema operacional em uso
            jPopupMenu1.show(tabela, evt.getX(), evt.getY()); //p é o JPopupMenu, t é a tabela, e.getX() recupera a posição horizontal do mouse e e.getY() recupera a posição vertical.
        }
    }//GEN-LAST:event_tabelaMouseReleased

    int id;

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        conecta.conexao();
        try {
            String nome = "" + tabela.getValueAt(tabela.getSelectedRow(), 0);
            conecta.executaSQL("SELECT * FROM person WHERE id = '" + nome + "'");
            conecta.rs.first();
            id = conecta.rs.getInt("id");
            txt_name.setText(String.valueOf(conecta.rs.getString("first_name")) + " " + String.valueOf(conecta.rs.getString("last_name")));
            txt_office.setText(String.valueOf(conecta.rs.getString("office")));
            txt_phone.setText(String.valueOf(conecta.rs.getString("phone_number")));
            txt_fb.setText(String.valueOf(conecta.rs.getString("profile_facebook")));
            txt_insta.setText(String.valueOf(conecta.rs.getString("profile_instagram")));
            txt_linkedin.setText(String.valueOf(conecta.rs.getString("profile_linkedin")));
            txt_github.setText(String.valueOf(conecta.rs.getString("profile_github")));
        } catch (SQLException s) {
            //JOptionPane.showMessageDialog(rootPane, "Erro ao Selecionar os Dados!\nErro:" + s);
        }
        conecta.desconecta();
    }//GEN-LAST:event_tabelaMouseClicked

    private void botaoexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoexcluirActionPerformed
        cod.deletar(id);
        cod.preencherTabela("SELECT * FROM person ORDER BY id", tabela);
    }//GEN-LAST:event_botaoexcluirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Data dialog = new Data(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem botaoexcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_fb;
    private javax.swing.JTextField txt_github;
    private javax.swing.JTextField txt_insta;
    private javax.swing.JTextField txt_linkedin;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_office;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
