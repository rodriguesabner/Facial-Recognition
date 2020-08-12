package com.kingaspx.util;

import com.kingaspx.main.Login;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RoundImage {

    private static final Stroke stroke = new BasicStroke(1.5f);

    public static Image getRoundImage(Image imageSource, int radius) {
        int width = imageSource.getWidth(null);
        int height = imageSource.getHeight(null);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        RoundRectangle2D rect = new RoundRectangle2D.Double(0, 0, width, height, radius, radius);

        Graphics2D g2 = (Graphics2D) image.getGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.clip(rect);
        g2.drawImage(imageSource, 0, 0, null);

        g2.setStroke(stroke);
        g2.setColor(new java.awt.Color(39,62,174));
        g2.draw(rect);

        return image;
    }

    public void arredondarFoto(JFrame frame, String caminho, JLabel label, int round) {
        try {
            ImageIcon icon = new ImageIcon(new ImageIcon(caminho).getImage().getScaledInstance(label.getWidth() + 95, label.getHeight() + 95, Image.SCALE_SMOOTH));
            label.setIcon(new ImageIcon(RoundImage.getRoundImage(icon.getImage(), round)));
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Imagem do usuário não encontrada.");
            new Login().setVisible(true);
            frame.dispose();
        }
    }
}
