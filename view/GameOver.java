/*
 * Decompiled with CFR 0_110.
 */
package view;

import model.Constants;

import javax.swing.*;
import java.net.URL;

public class GameOver
extends JWindow {
    private static final long serialVersionUID = -4665266911337393569L;
    private URL imageUrl = ClassLoader.getSystemResource("images/game-over.jpg");

    public GameOver() {
        JLabel gameover = new JLabel(new ImageIcon(this.imageUrl));
        this.add(gameover);
        this.setSize(Constants.GAMEOVER_SIZE);
        int x = (Constants.BOARD_WIDTH - Constants.GAMEOVER_SIZE.width) / 2;
        int y = (Constants.BOARD_WIDTH - Constants.GAMEOVER_SIZE.height) / 2;
        this.setLocation(x, y);
        this.setVisible(true);
    }
}

