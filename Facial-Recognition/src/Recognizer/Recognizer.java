package Recognizer;

import Util.ConectaBanco;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_face;
import static org.bytedeco.javacpp.opencv_imgcodecs.imencode;
import org.bytedeco.javacpp.opencv_imgproc;
import static org.bytedeco.javacpp.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvtColor;
import static org.bytedeco.javacpp.opencv_imgproc.rectangle;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacpp.opencv_videoio;

public final class Recognizer extends javax.swing.JFrame {

    private Recognizer.DaemonThread myThread = null;

    //JavaCV
    opencv_videoio.VideoCapture webSource = null;
    opencv_core.Mat cameraImage = new opencv_core.Mat();
    opencv_objdetect.CascadeClassifier cascade = new opencv_objdetect.CascadeClassifier("C:\\photos\\haarcascade_frontalface_alt.xml");
    opencv_face.FaceRecognizer recognizer = opencv_face.LBPHFaceRecognizer.create();

    BytePointer mem = new BytePointer();
    opencv_core.RectVector detectedFaces = new opencv_core.RectVector();

    //Vars
    String root, firstNamePerson, lastNamePerson, officePerson, dobPerson, telefone;
    //Social Info
    String facebook, insta, linkedin, git;
    int idPerson;

    //Utils
    ConectaBanco conecta = new ConectaBanco();

    public Recognizer() {
        initComponents();

        recognizer.read("C:\\photos\\classifierLBPH.yml");
        recognizer.setThreshold(80);

        startCamera();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sendMessage_btn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        label_phone = new javax.swing.JLabel();
        label_name = new javax.swing.JLabel();
        label_office = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_id_label = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        label_github = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        label_photo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Security System - Recognizer");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sendMessage_btn.setBackground(new java.awt.Color(104, 151, 197));
        sendMessage_btn.setForeground(new java.awt.Color(255, 255, 255));
        sendMessage_btn.setText("Send Message to $NumberPhone");
        sendMessage_btn.setContentAreaFilled(false);
        sendMessage_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendMessage_btn.setOpaque(true);
        sendMessage_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessage_btnActionPerformed(evt);
            }
        });
        jPanel1.add(sendMessage_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 370, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(200, 204, 208));
        jLabel11.setText("Your personal info");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setText("Office:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        jLabel3.setText("Name:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jLabel4.setText("Phone:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 380, 10));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 380, 10));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 380, 10));
        jPanel4.add(label_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 380, 20));
        jPanel4.add(label_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 380, 20));
        jPanel4.add(label_office, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 380, 20));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 430, 140));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(95, 106, 117));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Hi, $name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 400, 40));

        txt_id_label.setBackground(new java.awt.Color(68, 128, 193));
        txt_id_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_id_label.setText("1");
        txt_id_label.setOpaque(true);
        jPanel1.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(200, 204, 208));
        jLabel12.setText("Your social network");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_GitHub_30px.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 50, -1));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Facebook_30px.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, -1));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Instagram_30px.png"))); // NOI18N
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 50, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_LinkedIn_30px.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 50, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 240, 100));

        label_github.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label_github.setForeground(new java.awt.Color(153, 153, 153));
        label_github.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(label_github, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 430, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 450, 420));

        kGradientPanel1.setkEndColor(new java.awt.Color(32, 199, 103));
        kGradientPanel1.setkStartColor(new java.awt.Color(132, 242, 145));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        kGradientPanel1.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 400));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 420));

        setSize(new java.awt.Dimension(796, 456));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sendMessage_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessage_btnActionPerformed
        new Send_Message(firstNamePerson, telefone).setVisible(true);
    }//GEN-LAST:event_sendMessage_btnActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                URI site = new URI("http://www.facebook.com/" + facebook);
                desktop.browse(site);
            } catch (IOException | URISyntaxException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                URI site = new URI("http://www.instagram.com/" + insta);
                desktop.browse(site);
            } catch (IOException | URISyntaxException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                URI site = new URI("http://www.linkedin.com/in/" + linkedin);
                desktop.browse(site);
            } catch (IOException | URISyntaxException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                URI site = new URI("http://www.github.com/" + git);
                desktop.browse(site);
            } catch (IOException | URISyntaxException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recognizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Recognizer().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel label_github;
    private javax.swing.JLabel label_name;
    private javax.swing.JLabel label_office;
    private javax.swing.JLabel label_phone;
    private javax.swing.JLabel label_photo;
    private javax.swing.JButton sendMessage_btn;
    private javax.swing.JLabel txt_id_label;
    // End of variables declaration//GEN-END:variables

    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    try {
                        if (webSource.grab()) {
                            webSource.retrieve(cameraImage);
                            Graphics g = label_photo.getGraphics();

                            opencv_core.Mat imageGray = new opencv_core.Mat();
                            cvtColor(cameraImage, imageGray, COLOR_BGRA2GRAY);

                            opencv_core.RectVector detectedFace = new opencv_core.RectVector();
                            cascade.detectMultiScale(imageGray, detectedFace, 1.1, 2, 0, new opencv_core.Size(150, 150), new opencv_core.Size(500, 500));

                            for (int i = 0; i < detectedFace.size(); i++) {
                                opencv_core.Rect dadosFace = detectedFace.get(i);
                                rectangle(cameraImage, dadosFace, new opencv_core.Scalar(0, 255, 0, 0));
                                opencv_core.Mat faceCapturada = new opencv_core.Mat(imageGray, dadosFace);
                                opencv_imgproc.resize(faceCapturada, faceCapturada, new opencv_core.Size(160, 160));

                                IntPointer rotulo = new IntPointer(1);
                                DoublePointer confidence = new DoublePointer(1);
                                recognizer.predict(faceCapturada, rotulo, confidence);
                                int prediction = rotulo.get(0);
                                String nome;
                                nome = firstNamePerson;

                                if (prediction == -1) {
                                    label_name.setText("Desconhecido");
                                    label_office.setText("");
                                    label_phone.setText("");
                                    idPerson = 0;
                                } else {
                                    System.out.println(confidence.get(0));
                                    idPerson = prediction;
                                    rec();
                                }
                            }

                            imencode(".bmp", cameraImage, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                            BufferedImage buff = (BufferedImage) im;

                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight() + 600, 0, 0, buff.getWidth() + 600, buff.getHeight() + 600, null)) {
                                if (runnable == false) {
                                    System.out.println("Salve a Foto");
                                    this.wait();
                                }
                            }
                        }
                    } catch (IOException | InterruptedException ex) {
                    }
                }
            }
        }

    }

    private void rec() {
        //Recognizer face with database
        SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                conecta.conexao();
                try {
                    String SQL = "SELECT * FROM person WHERE id = " + String.valueOf(idPerson);
                    conecta.executaSQL(SQL);
                    while (conecta.rs.next()) {
                        firstNamePerson = conecta.rs.getString("first_name");
                        jLabel10.setText("Hi, " + firstNamePerson + " " + conecta.rs.getString("last_name"));
                        label_name.setText(conecta.rs.getString("first_name") + " " + conecta.rs.getString("last_name"));
                        label_office.setText(conecta.rs.getString("office"));
                        telefone = conecta.rs.getString("phone_number");
                        label_phone.setText(telefone);
                        sendMessage_btn.setText("Send Message to " + conecta.rs.getString("phone_number"));
                        txt_id_label.setText(conecta.rs.getString("id"));

                        //Social Info
                        facebook = conecta.rs.getString("profile_facebook");
                        insta = conecta.rs.getString("profile_instagram");
                        linkedin = conecta.rs.getString("profile_linkedin");
                        git = conecta.rs.getString("profile_github");
                        label_github.setText(git);

                        Array ident = conecta.rs.getArray("first_name");
                        String[] person = (String[]) ident.getArray();

                        for (int i = 0; i < person.length; i++) {
                            System.out.println(person[i]);
                        }
                    }
                } catch (Exception e) {
                }
                conecta.desconecta();
                return null;
            }
        };
        worker.execute();
    }

    public void stopCamera() {
        myThread.runnable = false;
        webSource.release();
        dispose();
    }

    public void startCamera() {
        webSource = new opencv_videoio.VideoCapture(0);
        myThread = new Recognizer.DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
    }

}
