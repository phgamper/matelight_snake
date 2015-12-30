/*
 * Decompiled with CFR 0_110.
 */
package model;

import controller.SnakeMover;
import view.FoodPanel;
import view.Matelight;
import view.SnakePanel;
import view.View;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Map map = Map.getInstance();
        View view = new View();
        Matelight mate = new Matelight();
        map.addObserver(view);
        map.initialize();
        Snake snake = Snake.getInstance();
        SnakePanel snakePanel = new SnakePanel();
        snake.addObserver(snakePanel);
        snake.addObserver(view);
        snake.addObserver(mate);
        SnakeMover.getInstance(snake);
        view.addJPanelToBoard(snakePanel);
        Food food = Food.getInstance();
        FoodPanel foodPanel = new FoodPanel();
        food.addObserver(foodPanel);
        view.addJPanelToBoard(foodPanel);
    }
}

