package ch.phgamper.matelight.view;


import ch.phgamper.matelight.model.Constants;
import ch.phgamper.matelight.model.Food;
import ch.phgamper.matelight.model.Point;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

public class FoodPanel extends JPanel implements Observer {
    private static final long serialVersionUID = 1;
    private Food food;

    public FoodPanel(Food food) {
        this.food = food;
        this.setSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setFocusable(false);
        this.setOpaque(true);
    }

    @Override
    public void paint(Graphics g) {
        int block = Constants.BLOCK_SIZE;
        super.paint(g);
        Point p = food.getFood();
        g.setColor(Color.RED);
        g.fillArc(p.X * block, p.Y * block, block, block, 0, 360);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }
}

