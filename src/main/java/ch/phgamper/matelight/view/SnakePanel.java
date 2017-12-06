package ch.phgamper.matelight.view;

import ch.phgamper.matelight.model.*;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class SnakePanel extends JPanel implements Observer {
    private static final long serialVersionUID = 1;
    private LinkedList<Point> last;

    private Snake snake;

    public SnakePanel(Snake snake) {
        this.snake = snake;
        this.last = snake.getSnake();
        this.setSize(new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        this.setFocusable(false);
        this.setOpaque(false);
    }

    @Override
    public void paint(Graphics g) {
        int x, i, y, a, b; int block = Constants.BLOCK_SIZE;
        super.paint(g);

        // clear snake
        g.setColor(Constants.BACKGROUND_COLOR);
        for (Point p : last) {
            g.fillRect(p.X * block, p.Y * block, block, block);
        }

        // repaint snake
        g.setColor(Color.GREEN);
        for (Point p: snake.getSnake()) {
            g.fillArc(p.X * block, p.Y * block, block, block, 0, 360);
        }

        // repaint eyes
        g.setColor(Color.WHITE);
        Point head = snake.getSnake().peek();
        for (i = 0; i < 2; ++i) {
            x = (int) Math.round((head.X + 0.2 * (1 + i * 2)) * block);
            y = (int) Math.round((head.Y + 0.2) * block);
            a = Math.round(6.0f);
            b = Math.round(7.0f);
            g.fillArc(x, y, a, b, 0, 360);
        }
        g.setColor(Color.BLACK);
        for (i = 0; i < 2; ++i) {
            x = (int) Math.round((head.X + 0.2 * (1.1 + i * 2))* block);
            y = (int) Math.round((head.Y + 0.3) * block);
            a = Math.round(4.0f);
            b = Math.round(5.0f);
            g.fillArc(x, y, a, b, 0, 360);
        }

        // repaint tongue
        int[] x2 = new int[]{(int) Math.floor((head.X + 0.333) * block), (int) Math.floor((head.X + 0.2) * block), (int) Math.floor(head.X * block), (int) Math.floor((head.X + 0.2) * block), (int) Math.floor((head.X  + 0.2) * block)};
        int[] y2 = new int[]{(int) Math.floor((head.Y + 0.8) * block), (int) Math.floor((head.Y + 0.833) * block), (int) Math.floor((head.Y + 0.833) * block), (int) Math.floor((head.Y + 0.833) * block), (int) Math.floor((head.Y + 1) * block) - 1};
        g.setColor(Color.RED);
        g.drawPolyline(x2, y2, 5);

        // store snake
        this.last = new LinkedList<>(snake.getSnake());

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void update(Observable o, Object obj) {
        this.repaint();
    }
}

