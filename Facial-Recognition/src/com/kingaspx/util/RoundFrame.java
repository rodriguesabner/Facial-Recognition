package com.kingaspx.util;

import java.awt.geom.RoundRectangle2D;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class RoundFrame {

    public void corner(JFrame frame, int w, int h, int c1, int c2) {
        int x = 0, y = 0;
        frame.setShape(new RoundRectangle2D.Double(x, y, w, h, c1, c2));
    }

    public void corner(JDialog dialog, int w, int h, int c1, int c2) {
        int x = 0, y = 0;
        dialog.setShape(new RoundRectangle2D.Double(x, y, w, h, c1, c2));
    }

}
