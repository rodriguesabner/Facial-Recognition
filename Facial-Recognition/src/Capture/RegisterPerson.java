package Capture;

import Util.ConectaBanco;
import Util.ControlPerson;
import Util.ModelPerson;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.opencv_core;
import static org.bytedeco.javacpp.opencv_core.CV_32SC1;
import org.bytedeco.javacpp.opencv_face;
import static org.bytedeco.javacpp.opencv_imgcodecs.imencode;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;
import org.bytedeco.javacpp.opencv_imgproc;
import static org.bytedeco.javacpp.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvtColor;
import static org.bytedeco.javacpp.opencv_imgproc.rectangle;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacpp.opencv_videoio;

public final class RegisterPerson extends javax.swing.JFrame {

    private RegisterPerson.DaemonThread myThread = null;

    //JavaCV
    opencv_videoio.VideoCapture webSource = null;
    opencv_core.Mat cameraImage = new opencv_core.Mat();
    opencv_objdetect.CascadeClassifier cascade = new opencv_objdetect.CascadeClassifier("C://photos//haarcascade_frontalface_alt.xml");
    BytePointer mem = new BytePointer();
    opencv_core.RectVector detectedFaces = new opencv_core.RectVector();

    String root;
    int numSamples = 25, sample = 1, idPerson;

    //Utils
    ConectaBanco conecta = new ConectaBanco();

    public RegisterPerson() {
        initComponents();
        showIdUser();
        startCamera();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_office = new javax.swing.JTextField();
        txt_first_name = new javax.swing.JTextField();
        txt_last_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_phone_number = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_id_label = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txt_linkedin = new javax.swing.JTextField();
        txt_facebook = new javax.swing.JTextField();
        txt_instagram = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_github = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        counterLabel = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        label_photo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Security System - Regiser Person");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_office.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 151, 197)));
        jPanel3.add(txt_office, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 170, -1));

        txt_first_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 151, 197)));
        jPanel3.add(txt_first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 170, -1));

        txt_last_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 151, 197)));
        jPanel3.add(txt_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 170, -1));

        jLabel2.setForeground(new java.awt.Color(170, 170, 170));
        jLabel2.setText("Office (Cargo): ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        jLabel3.setForeground(new java.awt.Color(170, 170, 170));
        jLabel3.setText("First Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel4.setForeground(new java.awt.Color(170, 170, 170));
        jLabel4.setText("Last Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jLabel5.setForeground(new java.awt.Color(170, 170, 170));
        jLabel5.setText("Phone Number");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        txt_phone_number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 151, 197)));
        try {
            txt_phone_number.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel3.add(txt_phone_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 170, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(200, 204, 208));
        jLabel10.setText("Personal Info");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txt_id_label.setBackground(new java.awt.Color(68, 128, 193));
        txt_id_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_id_label.setText("1");
        txt_id_label.setOpaque(true);
        jPanel3.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 40, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 440, 180));

        saveButton.setBackground(new java.awt.Color(104, 151, 197));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Finish");
        saveButton.setContentAreaFilled(false);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saveButton.setOpaque(true);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 370, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("At the end of the registration, take 25 photos!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 300, 20));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_linkedin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 151, 197)));
        jPanel4.add(txt_linkedin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 170, -1));

        txt_facebook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 151, 197)));
        jPanel4.add(txt_facebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 170, -1));

        txt_instagram.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 151, 197)));
        jPanel4.add(txt_instagram, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 170, -1));

        jLabel6.setForeground(new java.awt.Color(170, 170, 170));
        jLabel6.setText("Github");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        jLabel7.setForeground(new java.awt.Color(170, 170, 170));
        jLabel7.setText("Facebook");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel8.setForeground(new java.awt.Color(170, 170, 170));
        jLabel8.setText("Instagram");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        jLabel9.setForeground(new java.awt.Color(170, 170, 170));
        jLabel9.setText("Linkedin");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txt_github.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(104, 151, 197)));
        jPanel4.add(txt_github, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 170, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(200, 204, 208));
        jLabel11.setText("Social Info");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 430, 150));

        counterLabel.setBackground(new java.awt.Color(255, 255, 255));
        counterLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        counterLabel.setForeground(new java.awt.Color(32, 78, 199));
        counterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        counterLabel.setText("00/25");
        counterLabel.setOpaque(true);
        jPanel1.add(counterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 120, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 450, 420));

        kGradientPanel1.setkEndColor(new java.awt.Color(199, 184, 33));
        kGradientPanel1.setkStartColor(new java.awt.Color(242, 232, 132));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        kGradientPanel1.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 400));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 420));

        setSize(new java.awt.Dimension(796, 456));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegisterPerson().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel counterLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel label_photo;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField txt_facebook;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JTextField txt_github;
    private javax.swing.JLabel txt_id_label;
    private javax.swing.JTextField txt_instagram;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_linkedin;
    private javax.swing.JTextField txt_office;
    private javax.swing.JFormattedTextField txt_phone_number;
    // End of variables declaration//GEN-END:variables

    private void showIdUser() {
        conecta.conexao();
        conecta.executaSQL("SELECT * FROM person ORDER BY id DESC LIMIT 1");
        try {
            conecta.rs.first();
            txt_id_label.setText(String.valueOf(conecta.rs.getInt("id")));
            int id = Integer.parseInt(txt_id_label.getText());
            id++;
            txt_id_label.setText(String.valueOf(id));
        } catch (Exception e) {
        }
    }

    class DaemonThread implements Runnable { //LINK CLASS IN DESCRIPTION

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                while (runnable) {
                    try {
                        if (webSource.grab()) {
                            webSource.retrieve(cameraImage);
                            Graphics g = label_photo.getGraphics();
                            opencv_core.Mat imageColor = new opencv_core.Mat();
                            imageColor = cameraImage;

                            opencv_core.Mat imageGray = new opencv_core.Mat();
                            cvtColor(imageColor, imageGray, COLOR_BGRA2GRAY);

                            opencv_core.RectVector detectedFaces = new opencv_core.RectVector();
                            cascade.detectMultiScale(imageColor, detectedFaces, 1.1, 1, 0, new opencv_core.Size(150, 150), new opencv_core.Size(500, 500));

                            for (int i = 0; i < detectedFaces.size(); i++) {
                                opencv_core.Rect dadosFace = detectedFaces.get(0);
                                rectangle(imageColor, dadosFace, new opencv_core.Scalar(255, 255, 255, 5));
                                opencv_core.Mat face = new opencv_core.Mat(imageGray, dadosFace);
                                opencv_imgproc.resize(face, face, new opencv_core.Size(160, 160));

                                if (saveButton.getModel().isPressed()) {

                                    if (sample <= numSamples) {
                                        String cropped = "C:\\photos\\person." + txt_id_label.getText() + "." + sample + ".jpg";
                                        imwrite(cropped, face);

                                        //System.out.println("Foto " + amostra + " capturada\n");
                                        counterLabel.setText(String.valueOf(sample) + "/25");
                                        sample++;
                                    }
                                    if (sample > 25) {
                                        generate();
                                        insertDatabase();
                                        System.out.println("File Generated");
                                        stopCamera();
                                    }
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

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro ao iniciar camera (IOEx)\n" + ex);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Erro ao iniciar camera (Interrupted)\n" + ex);
                    }
                }
            }
        }
    }

    public void generate() {
        File directory = new File("C:\\photos\\");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg") || name.endsWith(".png");
            }
        };

        File[] files = directory.listFiles(filter); //only our filter
        opencv_core.MatVector photos = new opencv_core.MatVector(files.length);
        opencv_core.Mat labels = new opencv_core.Mat(files.length, 1, CV_32SC1);
        IntBuffer labelsBuffer = labels.createBuffer();

        int counter = 0;
        for (File image : files) {
            opencv_core.Mat photo = imread(image.getAbsolutePath(), COLOR_BGRA2GRAY);
            int idP = Integer.parseInt(image.getName().split("\\.")[1]);
            opencv_imgproc.resize(photo, photo, new opencv_core.Size(160, 160));

            photos.put(counter, photo);
            labelsBuffer.put(counter, idP);
            counter++;
        }

        opencv_face.FaceRecognizer lbph = opencv_face.LBPHFaceRecognizer.create();
        lbph.train(photos, labels);
        lbph.save("C:\\photos\\classifierLBPH.yml");
    }

    public void insertDatabase() {
        ControlPerson cod = new ControlPerson();
        ModelPerson mod = new ModelPerson();

        mod.setId(Integer.parseInt(txt_id_label.getText()));
        mod.setFirst_name(txt_first_name.getText());
        mod.setLast_name(txt_last_name.getText());
        mod.setDob(txt_phone_number.getText());
        mod.setOffice(txt_office.getText());
        mod.setFacebook(txt_facebook.getText());
        mod.setInstagram(txt_instagram.getText());
        mod.setLinkedin(txt_linkedin.getText());
        mod.setGithub(txt_github.getText());
        cod.inserir(mod);
    }

    public void stopCamera() {
        myThread.runnable = false;
        webSource.release();
        dispose();
    }

    public void startCamera() {
        webSource = new opencv_videoio.VideoCapture(0);
        myThread = new RegisterPerson.DaemonThread();
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();
    }

}
