package ch.phgamper.matelight.view;


import ch.phgamper.matelight.controller.SnakeMover;
import ch.phgamper.matelight.model.Constants;
import ch.phgamper.matelight.model.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

public class View extends JFrame implements Observer, ActionListener, WindowListener, KeyListener {

    private static final long serialVersionUID = -8177700681218036921L;

    private Board board = new Board();
    private JLabel score = new JLabel();

    private SnakeMover mover;

    public View(SnakeMover mover) {
        super("Matelight - Snake");
        this.mover = mover;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            listener();
            build();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void listener() {
        addKeyListener(this);
        addWindowListener(this);
    }

    private void build() {
        setLayout(new BorderLayout());
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        score.setSize(new Dimension(Constants.BAR_WIDTH, Constants.BAR_HEIGHT));
        score.setText(" Score: 0 ");
        add(board, "Center");
        add(score, "North");
        setVisible(true);
    }

    public void addToBoard(JPanel jpanel) {
        board.add(jpanel);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Snake) {
            Integer score = arg instanceof Integer ? (Integer) arg : 0;
            this.score.setText(" Score: " + score);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(3);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        mover.setEvent(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

