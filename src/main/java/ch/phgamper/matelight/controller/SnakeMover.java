package ch.phgamper.matelight.controller;

import ch.phgamper.matelight.model.Cheats;
import ch.phgamper.matelight.model.Snake;

import java.awt.event.KeyEvent;

public class SnakeMover implements Runnable {

    private Thread thread;
    private Snake snake;
    private KeyEvent event = null;
    private Cheats cheats = null;

    public SnakeMover(Snake snake, Cheats cheats){
        this(snake);
        this.cheats = cheats;
    }

    public SnakeMover(Snake snake) {
        this.snake = snake;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Starts the Game
     */
    @Override
    public void run() {
        while (!snake.isGameOver()) {
            try {
                KeyEvent event = this.event;
                Thread.sleep(snake.getSpeed());
                if (event == null) continue;
                switch (event.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        this.snake.moveLeft();
                        break;
                    case KeyEvent.VK_UP:
                        this.snake.moveUp();
                        break;
                    case KeyEvent.VK_RIGHT:
                        this.snake.moveRight();
                        break;
                    case KeyEvent.VK_DOWN:
                        this.snake.moveDown();
                        break;
                    default:
                        break;
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Handles key events
     *
     * @param e key pressed
     */
    public void setEvent(KeyEvent e) {
        if (event != null) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    event = event.getKeyCode() == KeyEvent.VK_RIGHT ? event :  e;
                    break;
                case KeyEvent.VK_UP:
                    event = event.getKeyCode() == KeyEvent.VK_DOWN ? event :  e;
                    break;
                case KeyEvent.VK_RIGHT:
                    event = event.getKeyCode() == KeyEvent.VK_LEFT ? event :  e;
                    break;
                case KeyEvent.VK_DOWN:
                    event = event.getKeyCode() == KeyEvent.VK_UP ? event :  e;
                    break;
                case KeyEvent.VK_F2:
                    if(snake.isGameOver()) {
                        event = null;
                        snake.newGame();
                        thread = new Thread(this);
                        thread.start();
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    snake.gameOver();
                    break;
                default: {
                    if(cheats != null){
                        cheats.cheat(e.getKeyCode());
                    }
                    break;
                }
            }
        } else {
            event = e;
        }
    }
}

