/*
 * Decompiled with CFR 0_110.
 */
package model;

import java.util.Observable;
import model.Map;
import model.Score;

public class Snake
extends Observable {
    private static Snake snake = new Snake();
    private int[][] snakepositions = new int[][]{{1, 0}, {0, 0}};

    private Snake() {
        Map.getInstance().addSnake(this.snakepositions);
    }

    public static Snake getInstance() {
        return snake;
    }

    public void moveDown() {
        int[] snakehead = new int[]{this.snakepositions[0][0], this.snakepositions[0][1] + 1};
        if (!Map.getInstance().isWall(snakehead)) {
            Map.getInstance().removeSnakeTail(this.snakepositions[this.snakepositions.length - 1]);
            if (!Map.getInstance().isSnake(snakehead)) {
                int[][] temppositions;
                if (Map.getInstance().isFood(snakehead)) {
                    Map.getInstance().eatFood(snakehead);
                    temppositions = new int[this.snakepositions.length + 1][2];
                    Score.getInstance().addPoints();
                } else {
                    temppositions = new int[this.snakepositions.length][2];
                }
                for (int i = 0; i < temppositions.length - 1; ++i) {
                    temppositions[i + 1][0] = this.snakepositions[i][0];
                    temppositions[i + 1][1] = this.snakepositions[i][1];
                }
                temppositions[0][0] = snakehead[0];
                temppositions[0][1] = snakehead[1];
                Map.getInstance().moveSnakeHead(snakehead);
                this.newSnakePositions(temppositions);
            } else {
                Map.getInstance().setGameOver(true);
            }
        } else {
            Map.getInstance().setGameOver(true);
        }
    }

    public void moveUp() {
        int[] snakehead = new int[]{this.snakepositions[0][0], this.snakepositions[0][1] - 1};
        if (!Map.getInstance().isWall(snakehead)) {
            Map.getInstance().removeSnakeTail(this.snakepositions[this.snakepositions.length - 1]);
            if (!Map.getInstance().isSnake(snakehead)) {
                int[][] temppositions;
                if (Map.getInstance().isFood(snakehead)) {
                    Map.getInstance().eatFood(snakehead);
                    temppositions = new int[this.snakepositions.length + 1][2];
                    Score.getInstance().addPoints();
                } else {
                    temppositions = new int[this.snakepositions.length][2];
                }
                for (int i = 0; i < temppositions.length - 1; ++i) {
                    temppositions[i + 1][0] = this.snakepositions[i][0];
                    temppositions[i + 1][1] = this.snakepositions[i][1];
                }
                temppositions[0][0] = snakehead[0];
                temppositions[0][1] = snakehead[1];
                Map.getInstance().moveSnakeHead(snakehead);
                this.newSnakePositions(temppositions);
            } else {
                Map.getInstance().setGameOver(true);
            }
        } else {
            Map.getInstance().setGameOver(true);
        }
    }

    public void moveRight() {
        int[] snakehead = new int[]{this.snakepositions[0][0] + 1, this.snakepositions[0][1]};
        if (!Map.getInstance().isWall(snakehead)) {
            Map.getInstance().removeSnakeTail(this.snakepositions[this.snakepositions.length - 1]);
            if (!Map.getInstance().isSnake(snakehead)) {
                int[][] temppositions;
                if (Map.getInstance().isFood(snakehead)) {
                    Map.getInstance().eatFood(snakehead);
                    temppositions = new int[this.snakepositions.length + 1][2];
                    Score.getInstance().addPoints();
                } else {
                    temppositions = new int[this.snakepositions.length][2];
                }
                for (int i = 0; i < temppositions.length - 1; ++i) {
                    temppositions[i + 1][0] = this.snakepositions[i][0];
                    temppositions[i + 1][1] = this.snakepositions[i][1];
                }
                temppositions[0][0] = snakehead[0];
                temppositions[0][1] = snakehead[1];
                Map.getInstance().moveSnakeHead(snakehead);
                this.newSnakePositions(temppositions);
            } else {
                Map.getInstance().setGameOver(true);
            }
        } else {
            Map.getInstance().setGameOver(true);
        }
    }

    public void moveLeft() {
        int[] snakehead = new int[]{this.snakepositions[0][0] - 1, this.snakepositions[0][1]};
        if (!Map.getInstance().isWall(snakehead)) {
            Map.getInstance().removeSnakeTail(this.snakepositions[this.snakepositions.length - 1]);
            if (!Map.getInstance().isSnake(snakehead)) {
                int[][] temppositions;
                if (Map.getInstance().isFood(snakehead)) {
                    Map.getInstance().eatFood(snakehead);
                    temppositions = new int[this.snakepositions.length + 1][2];
                    Score.getInstance().addPoints();
                } else {
                    temppositions = new int[this.snakepositions.length][2];
                }
                for (int i = 0; i < temppositions.length - 1; ++i) {
                    temppositions[i + 1][0] = this.snakepositions[i][0];
                    temppositions[i + 1][1] = this.snakepositions[i][1];
                }
                temppositions[0][0] = snakehead[0];
                temppositions[0][1] = snakehead[1];
                Map.getInstance().moveSnakeHead(snakehead);
                this.newSnakePositions(temppositions);
            } else {
                Map.getInstance().setGameOver(true);
            }
        } else {
            Map.getInstance().setGameOver(true);
        }
    }

    private void newSnakePositions(int[][] temppositions) {
        this.snakepositions = new int[temppositions.length][2];
        for (int i = 0; i < temppositions.length; ++i) {
            this.snakepositions[i][0] = temppositions[i][0];
            this.snakepositions[i][1] = temppositions[i][1];
        }
        this.update();
    }

    public void update() {
        this.setChanged();
        this.notifyObservers();
    }

    public int[][] getSnakepositions() {
        return this.snakepositions;
    }

    public void setSnakepositions(int[][] snakepositions) {
        this.snakepositions = snakepositions;
    }
}

