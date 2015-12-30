package ch.phgamper.matelight.model;

import java.util.Observable;
import java.util.Random;

public class Food extends Observable {

    private Random rand = new Random();

    private Point food;

    /**
     * Places the a new food
     *
     * @param snake to prevent placing the food on it
     */
    public void next(Snake snake) {
        int x = rand.nextInt(Constants.xLen);
        int y = rand.nextInt(Constants.yLen);
        while (snake.isSnake(x, y)) {
            x = rand.nextInt(Constants.xLen);
            y = rand.nextInt(Constants.yLen);
        }
        food = new Point(x, y);
        this.setChanged();
        this.notifyObservers();
    }

    /**
     *
     * @return the coordinates of the food
     */
    public Point getFood(){
        return food;
    }

    /**
     *
     * @param head of the snake
     * @return whether the snake got some food
     */
    public boolean isFood(Point head){
        return food.equals(head);
    }
}

