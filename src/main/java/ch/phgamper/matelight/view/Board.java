package ch.phgamper.matelight.view;


import ch.phgamper.matelight.model.Constants;

import javax.swing.*;
import java.awt.*;

public class Board extends JLayeredPane {
    private static final long serialVersionUID = 7704761091317274700L;

    public Board() {
        setSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        setOpaque(true);
        setBackground(Constants.BACKGROUND_COLOR);
        setBorder(Constants.BLACK_LINE);
    }
}

