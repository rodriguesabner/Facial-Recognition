package com.kingaspx.recognizer;

import com.kingaspx.util.ConectaBanco;
import com.kingaspx.util.RoundFrame;
import java.awt.Desktop;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class SendWhatsapp extends javax.swing.JDialog {

    String tel, name;
    ConectaBanco conecta = new ConectaBanco();

    public SendWhatsapp(java.awt.Frame parent, boolean modal, String nome, String telefone) {
        super(parent, modal);
        initComponents();
        new RoundFrame().corner(SendWhatsapp.this, 480, 340, 10, 10);
        name = nome;
        tel = telefone;
        number_lbl.setText(tel);
        text_lbl.setText("Olá," + name + "! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!");
    }
    
    public SendWhatsapp(JDialog parent, boolean modal, String nome, String telefone) {
        super(parent, modal);
        initComponents();
        new RoundFrame().corner(SendWhatsapp.this, 480, 340, 10, 10);
        name = nome;
        tel = telefone;
        number_lbl.setText(tel);
        text_lbl.setText("Olá," + name + "! Este é o último projeto do reconhecimento facial! Meu nome é Abner e você pode aprender comigo!");
    }

    private SendWhatsapp(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        kButton1 = new keeptoo.KButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        kButton3 = new keeptoo.KButton();
        jLabel3 = new javax.swing.JLabel();
        number_lbl = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_lbl = new javax.swing.JTextArea();
        caracteres_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Notificação");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton1.setBorder(null);
        kButton1.setForeground(new java.awt.Color(115, 116, 122));
        kButton1.setText("Cancel");
        kButton1.setFocusPainted(false);
        kButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        kButton1.setkAllowGradient(false);
        kButton1.setkAllowTab(false);
        kButton1.setkBackGroundColor(new java.awt.Color(215, 215, 215));
        kButton1.setkFillButton(false);
        kButton1.setkForeGround(new java.awt.Color(115, 116, 122));
        kButton1.setkHoverColor(new java.awt.Color(206, 206, 206));
        kButton1.setkHoverForeGround(new java.awt.Color(115, 116, 122));
        kButton1.setkPressedColor(new java.awt.Color(115, 116, 122));
        kButton1.setOpaque(false);
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 120, 30));
        kButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_WhatsApp_25px.png"))); // NOI18N
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 40, 30));

        jButton1.setToolTipText("Fechar");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 40, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(53, 56, 67));
        jLabel2.setText("Send SMS");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        kButton3.setText("Send");
        kButton3.setFocusPainted(false);
        kButton3.setkAllowGradient(false);
        kButton3.setkAllowTab(false);
        kButton3.setkBackGroundColor(new java.awt.Color(90, 82, 255));
        kButton3.setkHoverColor(new java.awt.Color(73, 66, 203));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton3.setkPressedColor(new java.awt.Color(55, 51, 133));
        kButton3.setOpaque(false);
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });
        kGradientPanel1.add(kButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 120, 30));
        kButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(43, 48, 56));
        jLabel3.setText("Message:");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        number_lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(214, 222, 231)));
        kGradientPanel1.add(number_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 320, 20));

        jSeparator1.setForeground(new java.awt.Color(247, 247, 247));
        kGradientPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 440, 10));

        jSeparator2.setForeground(new java.awt.Color(247, 247, 247));
        kGradientPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 440, 10));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(43, 48, 56));
        jLabel4.setText("Phone Number:");
        kGradientPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(214, 222, 231)));

        text_lbl.setColumns(20);
        text_lbl.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        text_lbl.setLineWrap(true);
        text_lbl.setRows(5);
        text_lbl.setWrapStyleWord(true);
        text_lbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_lblKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(text_lbl);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 440, 160));

        caracteres_label.setForeground(new java.awt.Color(61, 61, 61));
        caracteres_label.setText("0 caracteres");
        kGradientPanel1.add(caracteres_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 140, 20));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 340));

        setSize(new java.awt.Dimension(480, 340));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        inserir();
        try {
            dispose();
            String url = "https://api.whatsapp.com/send?phone=55" + tel.replace(" ", "").replace("(", "").replace(")", "").replace("-", "") + "&text=" + text_lbl.getText().replace(" ", "%20"); //Brazil code
            Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_kButton3ActionPerformed

    private void text_lblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_lblKeyReleased
        if (text_lbl.getText().length() == 1) {
            caracteres_label.setText(text_lbl.getText().length() + " caractere");
        } else {
            caracteres_label.setText(text_lbl.getText().length() + " caracteres");
        }
    }//GEN-LAST:event_text_lblKeyReleased

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
            java.util.logging.Logger.getLogger(SendWhatsapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendWhatsapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendWhatsapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendWhatsapp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            SendWhatsapp dialog = new SendWhatsapp(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel caracteres_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JTextField number_lbl;
    private javax.swing.JTextArea text_lbl;
    // End of variables declaration//GEN-END:variables

    public void inserir() {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO ws_msg (msg, phone) VALUES (?, ?)");
            pst.setString(1, text_lbl.getText());
            pst.setString(2, tel);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        conecta.desconecta();
    }

}
