package model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public interface Constants {
    public static final Border BLACK_LINE = BorderFactory.createLineBorder(Color.BLACK);
    public static final Color BACKGROUND_COLOR = new Color(0, 0, 0);
    public static final int xLen = 40;
    public static final int yLen = 16;
    public static final int BLOCK_SIZE = 30;
    public static final int BOARD_WIDTH = xLen * BLOCK_SIZE;
    public static final int BOARD_HEIGHT = yLen * BLOCK_SIZE;
    public static final int FRAME_WIDTH = BOARD_WIDTH + 10;
    public static final int FRAME_HEIGHT = BOARD_HEIGHT + 20;
    public static final int FIELDS = 640;
    public static final int SPEED = 100;
    public static final Dimension GAMEOVER_SIZE = new Dimension(200, 133);
    public static final int ADD_POINTS = 50;
}

