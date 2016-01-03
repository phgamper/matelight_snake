package ch.phgamper.matelight.model;

import java.awt.event.KeyEvent;
import java.util.Random;

public class Cheats {

    private Snake snake;

    public Cheats(Snake snake){
        this.snake = snake;
    }


    /**
     * Handles cheat requests
     *
     * @param keyCode to handle
     */
    public void cheat(int keyCode){
       switch (keyCode){
           case KeyEvent.VK_F11:
               doubleOrZeroPoints();
               break;
           case KeyEvent.VK_F12:
               halfOrDoubleSpeed();
               break;
           default:
               break;
       }
    }

    /**
     * 33% chance to double the points, 66% chance to zero them
     */
    private void doubleOrZeroPoints() {
        int rand = new Random().nextInt(3);
        Score score = snake.getScore();
        if (rand == 2) {
            score.setPoints(score.getPoints()*2);
        } else {
            score.setPoints(0);
        }
    }

    /**
     * 50% chance to half the speed, die otherwise
     */
    private void halfSpeedOrDie() {
        int rand = new Random().nextInt(2);
        if (rand == 1) {
            snake.setSpeed(snake.getSpeed()*2);
        } else {
            snake.gameOver();
        }
    }

    /**
     * 50% chance to half or double the speed
     */
    private void halfOrDoubleSpeed() {
        int rand = new Random().nextInt(2);
        if (rand == 1) {
            snake.setSpeed(snake.getSpeed()*2);
        } else {
            snake.setSpeed(snake.getSpeed()/2);
        }
    }
}
