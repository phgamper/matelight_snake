package ch.phgamper.matelight.model;

import ch.phgamper.matelight.controller.SnakeMover;
import ch.phgamper.matelight.view.FoodPanel;
import ch.phgamper.matelight.view.Matelight;
import ch.phgamper.matelight.view.SnakePanel;
import ch.phgamper.matelight.view.View;

public class Main {

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Usage: host port");
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        new Main(host, port);
    }

    public Main(String host, int port) {
        Matelight mate = new Matelight(host, port);
        Food food = new Food();
        Score score = new Score();
        Snake snake = new Snake(food, score);
        SnakeMover mover = new SnakeMover(snake);
        View view = new View(mover);

        SnakePanel snakePanel = new SnakePanel(snake);
        FoodPanel foodPanel = new FoodPanel(food);

        food.addObserver(foodPanel);
        snake.addObserver(snakePanel);
        snake.addObserver(view);
        snake.addObserver(mate);

        view.addToBoard(foodPanel);
        view.addToBoard(snakePanel);
    }
}

