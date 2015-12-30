package ch.phgamper.matelight.model;

import java.util.Observable;
import java.util.Random;

public class Food extends Observable {

    private Random rand = new Random();

    private Point food;

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

    public Point getFood(){
        return food;
    }

    public boolean isFood(Point head){
        return food.equals(head);
    }
}

