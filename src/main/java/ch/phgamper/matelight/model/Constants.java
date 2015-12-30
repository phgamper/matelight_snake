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
    int FRAME_WIDTH = BOARD_WIDTH + 10;
    int FRAME_HEIGHT = BOARD_HEIGHT + 50;
    int FIELDS = 640;
    int SPEED = 100;
    int ADD_POINTS = 50;
}


