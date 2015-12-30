package ch.phgamper.matelight.model;

import ch.phgamper.matelight.controller.SnakeMover;
import ch.phgamper.matelight.view.FoodPanel;
import ch.phgamper.matelight.view.Matelight;
import ch.phgamper.matelight.view.SnakePanel;
import ch.phgamper.matelight.view.View;

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

