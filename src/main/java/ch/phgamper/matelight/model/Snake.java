package ch.phgamper.matelight.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

public class Snake extends Observable {
    private LinkedList<Point> snake = new LinkedList<>();
    private Food food;
    private boolean gameOver = false;

    public Snake(Food food) {
        this.food = food;
        snake.add(new Point(2, 0));
        snake.add(new Point(1, 0));
        snake.add(new Point(0, 0));
        this.food.next(this);
    }

    public void moveDown() {
        Point head = snake.peek();
        if (!isWall(head) && !isSnake(head)) {
            snake.addFirst(new Point(head.X, head.Y + 1));
            if (!food.isFood(head)) {
                snake.removeLast();
            }
        } else {
            gameOver = true;
        }
        update();
    }

    public void moveUp() {
        Point head = snake.peek();
        if (!isWall(head) && !isSnake(head)) {
            snake.addFirst(new Point(head.X, head.Y - 1));
            if (!food.isFood(head)) {
                snake.removeLast();
            }
        } else {
            gameOver = true;
        }
        update();
    }

    public void moveRight() {
        Point head = snake.peek();
        if (!isWall(head) && !isSnake(head)) {
            snake.addFirst(new Point(head.X + 1, head.Y));
            if (!food.isFood(head)) {
                snake.removeLast();
            } else {
                food.next(this);
            }
        } else {
            gameOver = true;
        }
        this.update();
    }

    public void moveLeft() {
        Point head = snake.peek();
        if (!isWall(head) && !isSnake(head)) {
            snake.addFirst(new Point(head.X - 1, head.Y));
            if (!food.isFood(head)) {
                snake.removeLast();
            }
        } else {
            gameOver = true;
        }
        update();
    }

    public void update() {
        this.setChanged();
        this.notifyObservers();
    }

    public boolean isSnake(Point head) {
        Iterator<Point> it = snake.iterator();
        // Skip first
        if(it.hasNext()) {
            it.next();
        }
        while (it.hasNext()) {
            if (head.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean isSnake(int x, int y) {
        return isSnake(new Point(x, y));
    }

    public boolean isWall(Point head) {
        return head.X < 0 || head.Y < 0 || head.X >= Constants.xLen || head.Y >= Constants.yLen;
    }

    public LinkedList<Point> getSnake() {
        return snake;
    }

    public boolean isGameOver() {
        return this.gameOver;
    }
}

