package ch.phgamper.matelight.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

public class Snake extends Observable {
    private LinkedList<Point> snake = new LinkedList<>();
    private Food food;
    private Score score;
    private boolean gameOver = false;

    public Snake(Food food, Score score) {
        this.food = food;
        this.score = score;
        newGame();
    }

    /**
     * Start a new game
     */
    public void newGame() {
        gameOver = false;
        snake.clear();
        snake.add(new Point(2, 0));
        snake.add(new Point(1, 0));
        snake.add(new Point(0, 0));
        food.next(this);
        score.reset();
    }

    /**
     * Move snake down
     */
    public void moveDown() {
        Point head = snake.peek();
        move(new Point(head.X, head.Y + 1));
    }

    /**
     * Move snake up
     */
    public void moveUp() {
        Point head = snake.peek();
        move(new Point(head.X, head.Y - 1));
    }

    /**
     * Move snake to the right
     */
    public void moveRight() {
        Point head = snake.peek();
        move(new Point(head.X + 1, head.Y));
    }

    /**
     * Move snake to the left
     */
    public void moveLeft() {
        Point head = snake.peek();
        move(new Point(head.X - 1, head.Y));
    }

    /**
     * Move the snake towards the given direction
     *
     * @param next new position of the snake's head
     */
    public void move(Point next){
        if (!isWall(next) && !isSnake(next)) {
            snake.addFirst(next);
            if (!food.isFood(next)) {
                snake.removeLast();
            } else {
                food.next(this);
                score.inc();
            }
        } else {
            gameOver = true;
        }
        this.update();
    }

    /**
     * Notify observers the snake has moved
     */
    public void update() {
        this.setChanged();
        this.notifyObservers();
    }

    /**
     *
     * @param head position to check
     * @return true if the snake is on the given position
     */
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

    /**
     *
     * @param x coordinate of position to check
     * @param y coordinate of position to check
     * @return true if the snake is on the given position
     */
    public boolean isSnake(int x, int y) {
        return isSnake(new Point(x, y));
    }

    /**
     *
     * @param head position to check
     * @return true if the given position is a wall
     */
    public boolean isWall(Point head) {
        return head.X < 0 || head.Y < 0 || head.X >= Constants.xLen || head.Y >= Constants.yLen;
    }

    /**
     *
     * @return the coordinates of the snake
     */
    public LinkedList<Point> getSnake() {
        return snake;
    }

    /**
     *
     * @return true if the player fails
     */
    public boolean isGameOver() {
        return this.gameOver;
    }

    /**
     *
     * @return food
     */
    public Food getFood() {
        return food;
    }

    /**
     *
     * @return the score
     */
    public Score getScore(){
        return score;
    }

}

