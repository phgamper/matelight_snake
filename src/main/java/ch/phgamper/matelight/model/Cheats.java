package ch.phgamper.matelight.model;

import java.util.Random;

import static java.awt.event.KeyEvent.*;

public class Cheats {

    private Snake snake;

    private int[] god = new int[]{ VK_A, VK_L, VK_E, VK_G, VK_A, VK_M };
    private int godIndex = 0;

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
           case VK_F11:
               doubleOrZeroPoints();
               break;
           case VK_F12:
               halfOrDoubleSpeed();
               break;
           case VK_A:
           case VK_L:
           case VK_E:
           case VK_G:
           case VK_M:
               godMode(keyCode);
               break;
           default:
               godIndex = 0;
               break;
       }
    }

    /**
     * Enables god mode if a particular key series was pressed
     *
     * @param keyCode received last
     */
    private void godMode(int keyCode) {
        if (godIndex < god.length && keyCode == god[godIndex]) {
            godIndex++;
        }else {
            godIndex = 0;
        }
        if(godIndex == god.length) {
            snake.godModeOn();
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
