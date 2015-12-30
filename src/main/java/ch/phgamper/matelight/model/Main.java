package ch.phgamper.matelight.model;

import ch.phgamper.matelight.controller.SnakeMover;
import ch.phgamper.matelight.view.FoodPanel;
import ch.phgamper.matelight.view.Matelight;
import ch.phgamper.matelight.view.SnakePanel;
import ch.phgamper.matelight.view.View;

public class Main {

    private Matelight mate = new Matelight();
    private View view;
    private Snake snake;
    private Food food = new Food();
    private SnakeMover mover;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        snake = new Snake(food);
        mover = new SnakeMover(snake);
        view = new View(mover);

        SnakePanel snakePanel = new SnakePanel(snake);
        FoodPanel foodPanel = new FoodPanel(food);

        food.addObserver(foodPanel);

        snake.addObserver(snakePanel);
        snake.addObserver(view);
        snake.addObserver(mate);

        view.addJPanelToBoard(foodPanel);
        view.addJPanelToBoard(snakePanel);
    }
}

