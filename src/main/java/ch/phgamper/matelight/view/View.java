package ch.phgamper.matelight.view;


import ch.phgamper.matelight.controller.SnakeMover;
import ch.phgamper.matelight.model.Constants;
import ch.phgamper.matelight.model.Score;

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
        super("Snake");
        this.mover = mover;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            this.listener();
            this.build();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void listener() {
        this.addKeyListener(this);
        this.addWindowListener(this);
    }

    private void build() {
        this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        this.score.setText(" Score: " + Score.getInstance().returnScore() + "");
        this.add(this.score, "South");
        this.add(this.board, "Center");
        this.setVisible(true);
    }

    public void addJPanelToBoard(JPanel jpanel) {
        this.board.addJPanel(jpanel);
    }

    @Override
    public void update(Observable o, Object obj) {
        /*
        if (o instanceof Snake) {
            this.score.setText(" Score: " + Score.getInstance().returnScore() + "");
        }
        */
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

