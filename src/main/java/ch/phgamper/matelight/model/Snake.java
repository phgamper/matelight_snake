package ch.phgamper.matelight.model;

import java.util.LinkedList;
import java.util.Observable;

public class Snake extends Observable {
    private LinkedList<Point> snake = new LinkedList<>();
    private Food food;
    private Score score;
    private boolean gameOver = false;
    private boolean walls = Constants.WALLS;
    private int speed = Constants.SPEED;

    public Snake(Food food, Score score) {
        this.food = food;
        this.score = score;
        newGame();
    }

    /**
     * Starts a new game
     */
    public void newGame() {
        gameOver = false;
        snake.clear();
        snake.add(new Point(2, 0));
        snake.add(new Point(1, 0));
        snake.add(new Point(0, 0));
        food.next(this);
        score.reset();
        speed = Constants.SPEED;
        setChanged();
        notifyObservers(0);
    }

    /**
     * Moves snake down
     */
    public void moveDown() {
        Point head = snake.peek();
        move(new Point(head.X, head.Y + 1));
    }

    /**
     * Moves snake up
     */
    public void moveUp() {
        Point head = snake.peek();
        move(new Point(head.X, head.Y - 1));
    }

    /**
     * Moves snake to the right
     */
    public void moveRight() {
        Point head = snake.peek();
        move(new Point(head.X + 1, head.Y));
    }

    /**
     * Moves snake to the left
     */
    public void moveLeft() {
        Point head = snake.peek();
        move(new Point(head.X - 1, head.Y));
    }

    /**
     * Moves the snake towards the given direction
     *
     * @param next new position of the snake's head
     */
    public void move(Point next){
        if ((!walls || !isWall(next)) && !isSnake(next)){
            if (isWall(next)) {
                next.X = next.X < 0 ? Constants.xLen - 1 : next.X;
                next.X = next.X >= Constants.xLen ? 0 : next.X;
                next.Y = next.Y < 0 ? Constants.yLen - 1 : next.Y;
                next.Y = next.Y >= Constants.yLen ? 0 : next.Y;
            }
            snake.addFirst(next);
            if (!food.isFood(next)) {
                snake.removeLast();
            } else {
                food.next(this);
                score.inc();
                if(score.getPoints() % Constants.SPEED_MODULO == 0){
                    speed -= Constants.SPEED_STEP;
                }
            }
        } else {
            gameOver = true;
        }
        setChanged();
        notifyObservers(score.getPoints());
    }

    /**
     *
     * @param next position to check
     * @return true if the snake is on the given position
     */
    public boolean isSnake(Point next) {
        for (Point p : snake) {
            if (next.equals(p)) {
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

    /**
     * Sets the speed
     *
     * @param speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     *
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set gameOver to true
     */
    public void gameOver() {
        gameOver = true;
    }
}

