package ch.phgamper.matelight.model;

import ch.phgamper.matelight.controller.SnakeMover;
import ch.phgamper.matelight.view.FoodPanel;
import ch.phgamper.matelight.view.Matelight;
import ch.phgamper.matelight.view.SnakePanel;
import ch.phgamper.matelight.view.View;

public class Main {

    public static void main(String[] args) {
        int port = 0;
        String host = null;
        if(args.length >= 2){
            host = args[0];
            port = Integer.parseInt(args[1]);
        }
        new Main(host, port);
    }

    public Main(String host, int port) {
        SnakeMover mover;
        Food food = new Food();
        Score score = new Score();
        Snake snake = new Snake(food, score);

        if(Constants.CHEATS){
            mover = new SnakeMover(snake, new Cheats(snake));
        }else{
            mover = new SnakeMover(snake);
        }
        View view = new View(mover);

        SnakePanel snakePanel = new SnakePanel(snake);
        FoodPanel foodPanel = new FoodPanel(food);

        food.addObserver(foodPanel);
        snake.addObserver(snakePanel);
        snake.addObserver(view);

        if(host != null && port > 0) {
            snake.addObserver(new Matelight(host, port));
        }
        view.addToBoard(foodPanel);
        view.addToBoard(snakePanel);
    }
}

