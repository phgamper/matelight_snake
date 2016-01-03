package ch.phgamper.matelight.model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public interface Constants {
    Border BLACK_LINE = BorderFactory.createLineBorder(Color.BLACK);
    Color BACKGROUND_COLOR = new Color(0, 0, 0);
    int xLen = 40;
    int yLen = 16;
    int BLOCK_SIZE = 30;
    int BOARD_WIDTH = xLen * BLOCK_SIZE;
    int BOARD_HEIGHT = yLen * BLOCK_SIZE;
    int BAR_WIDTH = BOARD_WIDTH;
    int BAR_HEIGHT = 10;
    int FRAME_WIDTH = BOARD_WIDTH + 10;
    int FRAME_HEIGHT = BOARD_HEIGHT + BAR_HEIGHT + 40; // strange bug
    int SPEED = 120;
    int SPEED_STEP = 10;
    int SPEED_MODULO = 200;
    int ADD_POINTS = 50;
    boolean WALLS = false;
    boolean CHEATS = false;
}


