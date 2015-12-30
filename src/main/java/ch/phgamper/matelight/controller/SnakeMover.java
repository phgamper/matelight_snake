package ch.phgamper.matelight.controller;

import ch.phgamper.matelight.model.Constants;
import ch.phgamper.matelight.model.Snake;

import java.awt.event.KeyEvent;

public class SnakeMover implements Runnable {

    private Snake snake;
    private KeyEvent event = null;

    public SnakeMover(Snake snake) {
        this.snake = snake;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!snake.isGameOver()) {
            try {
                KeyEvent event = this.event;
                Thread.sleep(Constants.SPEED);
                if (event == null) continue;
                switch (event.getKeyCode()) {
                    case 37: {
                        this.snake.moveLeft();
                        break;
                    }
                    case 38: {
                        this.snake.moveUp();
                        break;
                    }
                    case 39: {
                        this.snake.moveRight();
                        break;
                    }
                    case 40: {
                        this.snake.moveDown();
                        break;
                    }
                    case 32: {
                        break;
                    }
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        snake.update();
    }

    public void setEvent(KeyEvent event) {
        if (this.event != null) {
            switch (event.getKeyCode()) {
                case 37: {
                    if (this.event.getKeyCode() == 39) return;
                    this.event = event;
                    break;
                }
                case 38: {
                    if (this.event.getKeyCode() == 40) return;
                    this.event = event;
                    break;
                }
                case 39: {
                    if (this.event.getKeyCode() == 37) return;
                    this.event = event;
                    break;
                }
                case 40: {
                    if (this.event.getKeyCode() == 38) return;
                    this.event = event;
                    break;
                }
                default: {
                    break;
                }
            }
        } else {
            this.event = event;
        }
    }
}

