/*
 * Decompiled with CFR 0_110.
 */
package view;

import model.Constants;
import model.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class SnakePanel
extends JPanel
implements Observer {
    private static final long serialVersionUID = 1;
    private int[][] lastPos = new int[][]{{0, 0}, {0, 0}};

    public SnakePanel() {
        this.setSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setFocusable(false);
        this.setOpaque(true);
    }

    @Override
    public void paint(Graphics g) {
        int x;
        int i;
        int y;
        int b;
        super.paint(g);
        g.setColor(Constants.BACKGROUND_COLOR);
        for (int[] values : this.lastPos) {
            g.fillRect(values[0] * 30, values[1] * 30, 30, 30);
        }
        int[][] pos = Snake.getInstance().getSnakepositions();
        g.setColor(Color.GREEN);
        for (int[] values2 : pos) {
            g.fillArc(values2[0] * 30, values2[1] * 30, 30, 30, 0, 360);
        }
        g.setColor(Color.WHITE);
        for (i = 0; i < 2; ++i) {
            x = Math.round(pos[0][0] * 30 + 6 * (1 + i * 2));
            y = Math.round(pos[0][1] * 30 + 6);
            int a = Math.round(6.0f);
            b = Math.round(7.0f);
            g.fillArc(x, y, a, b, 0, 360);
        }
        g.setColor(Color.BLACK);
        for (i = 0; i < 2; ++i) {
            x = (int)Math.round((double)(pos[0][0] * 30) + 6.0 * (1.1 + (double)(i * 2)));
            y = (int)Math.round((double)(pos[0][1] * 30) + 9.0);
            int a = Math.round(4.0f);
            b = Math.round(5.0f);
            g.fillArc(x, y, a, b, 0, 360);
        }
        int[] x2 = new int[]{(int)Math.floor(pos[0][0] * 30 + 10), (int)Math.floor(pos[0][0] * 30 + 6), (int)Math.floor(pos[0][0] * 30), (int)Math.floor(pos[0][0] * 30 + 6), (int)Math.floor(pos[0][0] * 30 + 6)};
        int[] y2 = new int[]{(int)Math.floor(pos[0][1] * 30 + 24), (int)Math.floor(pos[0][1] * 30 + 25), (int)Math.floor(pos[0][1] * 30 + 25), (int)Math.floor(pos[0][1] * 30 + 25), (int)Math.floor(pos[0][1] * 30 + 30) - 1};
        g.setColor(Color.RED);
        g.drawPolyline(x2, y2, 5);
        this.lastPos = new int[pos.length][2];
        for (int i2 = 0; i2 < pos.length; ++i2) {
            this.lastPos[i2][0] = pos[i2][0];
            this.lastPos[i2][1] = pos[i2][1];
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }
}

