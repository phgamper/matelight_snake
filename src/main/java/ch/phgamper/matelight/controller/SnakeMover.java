/*
 * Decompiled with CFR 0_110.
 */
package controller;

import model.Constants;
import model.Map;
import model.Snake;

import java.awt.event.KeyEvent;

public class SnakeMover
implements Runnable {
    private static SnakeMover mover = new SnakeMover();
    private Thread runtime;
    private Snake snake;
    private KeyEvent event = null;

    private SnakeMover() {
        this.runtime = new Thread(this);
        this.runtime.start();
    }

    public static SnakeMover getInstance(KeyEvent e) {
        mover.setEvent(e);
        return mover;
    }

    public static SnakeMover getInstance(Snake snake) {
        mover.setSnake(snake);
        return mover;
    }

    @Override
    public void run() {
        while (!Map.getInstance().isGameOver()) {
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
        Map.getInstance().update();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void setEvent(KeyEvent event) {
        if (this.event != null) {
            switch (event.getKeyCode()) {
                case 37: {
                    if (this.event.getKeyCode() == 39) return;
                    this.event = event;
                    return;
                }
                case 38: {
                    if (this.event.getKeyCode() == 40) return;
                    this.event = event;
                    return;
                }
                case 39: {
                    if (this.event.getKeyCode() == 37) return;
                    this.event = event;
                    return;
                }
                case 40: {
                    if (this.event.getKeyCode() == 38) return;
                    this.event = event;
                    return;
                }
                default: {
                    return;
                }
            }
        } else {
            this.event = event;
        }
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}

