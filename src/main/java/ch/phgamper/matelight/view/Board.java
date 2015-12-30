/*
 * Decompiled with CFR 0_110.
 */
package view;

import model.Constants;

import javax.swing.*;
import java.awt.*;

public class Board
extends JLayeredPane {
    private static final long serialVersionUID = 7704761091317274700L;

    public Board() {
        this.build();
    }

    private void build() {
        this.setPreferredSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        this.setOpaque(true);
        this.setBackground(Constants.BACKGROUND_COLOR);
        this.setBorder(Constants.BLACK_LINE);
    }

    public void addJPanel(JPanel jpanel) {
        this.add(jpanel);
    }

    public void gameOver() {
        new GameOver();
    }
}

