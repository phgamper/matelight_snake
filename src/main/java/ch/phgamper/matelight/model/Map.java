package ch.phgamper.matelight.model;

import java.util.Observable;

public class Map
        extends Observable {
    private static Map map = new Map();
    private int[][] fields;
    private boolean gameOver = false;

    public static Map getInstance() {
        return map;
    }

    public void initialize() {
        this.fields = new int[Constants.xLen][Constants.yLen];
        for (int x = 0; x < this.fields.length; ++x) {
            for (int y = 0; y < this.fields[x].length; ++y) {
                this.fields[x][y] = 0;
            }
        }
        this.update();
    }

    public void addFood(int[] position) {
        this.fields[position[0]][position[1]] = 2;
    }

    public void addSnake(int[][] positions) {
        for (int[] pos : positions) {
            this.fields[pos[0]][pos[1]] = 1;
        }
    }

    public void moveSnakeHead(int[] position) {
        this.fields[position[0]][position[1]] = 1;
    }

    public void removeSnakeTail(int[] position) {
        this.fields[position[0]][position[1]] = 0;
    }

    public void eatFood(int[] foodposition) {
        this.fields[foodposition[0]][foodposition[1]] = 0;
        Food.getInstance().nextFoodPosition();
    }

    public boolean isWall(int[] snakehead) {
        if (snakehead[0] >= Constants.xLen || snakehead[1] >= Constants.yLen || snakehead[0] < 0 || snakehead[1] < 0) {
            return true;
        }
        return false;
    }

    public boolean isFood(int[] snakehead) {
        return this.fields[snakehead[0]][snakehead[1]] == 2;
    }

    public boolean isSnake(int[] position) {
        return this.fields[position[0]][position[1]] == 1;
    }

    public void update() {
        this.setChanged();
        this.notifyObservers();
    }

    public boolean isGameOver() {
        return this.gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}

