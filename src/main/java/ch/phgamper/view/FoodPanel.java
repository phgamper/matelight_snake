/*
 * Decompiled with CFR 0_110.
 */
package view;

import model.Constants;
import model.Food;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class FoodPanel
extends JPanel
implements Observer {
    private static final long serialVersionUID = 1;

    public FoodPanel() {
        this.setSize(new Dimension(Constants.BOARD_WIDTH, Constants.FRAME_HEIGHT));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setFocusable(false);
        this.setOpaque(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int[] pos = Food.getInstance().getPosition();
        g.setColor(Color.RED);
        g.fillArc(pos[0] * 30, pos[1] * 30, 30, 30, 0, 360);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }
}

