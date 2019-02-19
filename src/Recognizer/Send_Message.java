package Recognizer;

import java.awt.Desktop;
import java.io.IOException;

public class Send_Message extends javax.swing.JFrame {

    String tel, name;

    public Send_Message(String nome, String telefone) {
        initComponents();
        name = nome;
        tel = telefone;
        jTextArea1.setText("Olá," + name + "! Este é um teste do YouFace, estou testando o envio de mensagens no WhatsApp. Sinta-se livre para escrever uma mensagem. :D");
    }

    private Send_Message() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        sendMessage_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Send Message WhatsApp");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(190, 230, 249)));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 130));

        sendMessage_btn.setBackground(new java.awt.Color(104, 151, 197));
        sendMessage_btn.setForeground(new java.awt.Color(255, 255, 255));
        sendMessage_btn.setText("Send");
        sendMessage_btn.setContentAreaFilled(false);
        sendMessage_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendMessage_btn.setOpaque(true);
        sendMessage_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessage_btnActionPerformed(evt);
            }
        });
        jPanel1.add(sendMessage_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 510, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 180));

        setSize(new java.awt.Dimension(545, 218));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sendMessage_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessage_btnActionPerformed
        try {
            String url = "https://api.whatsapp.com/send?phone=55" + tel.replace(" ", "").replace("(", "").replace(")", "").replace("-", "") + "&text=" + jTextArea1.getText().replace(" ", "%20"); //Brazil code
            Desktop.getDesktop().browse(java.net.URI.create(url));
            dispose();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_sendMessage_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Send_Message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Send_Message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Send_Message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Send_Message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Send_Message().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton sendMessage_btn;
    // End of variables declaration//GEN-END:variables
}
