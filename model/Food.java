/*
 * Decompiled with CFR 0_110.
 */
package model;

import java.util.Observable;
import java.util.Random;

public class Food
extends Observable {
    private static Food food = new Food();
    private Random rand = new Random();
    private int[] position = new int[2];

    private Food() {
        this.nextFoodPosition();
        Map.getInstance().addFood(this.position);
    }

    public static Food getInstance() {
        return food;
    }

    public void nextFoodPosition() {
        this.position[0] = this.rand.nextInt(Constants.xLen);
        this.position[1] = this.rand.nextInt(Constants.yLen);
        while (Map.getInstance().isSnake(this.position)) {
            this.position[0] = this.rand.nextInt(Constants.xLen);
            this.position[1] = this.rand.nextInt(Constants.yLen);
        }
        Map.getInstance().addFood(this.position);
        this.setChanged();
        this.notifyObservers();
    }

    public int[] getPosition() {
        return this.position;
    }
}

