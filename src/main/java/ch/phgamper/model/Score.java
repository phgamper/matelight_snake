/*
 * Decompiled with CFR 0_110.
 */
package model;

public class Score {
    private static Score score = new Score();
    private int points = 0;

    private Score() {
    }

    public static Score getInstance() {
        return score;
    }

    public void addPoints() {
        this.points += Constants.ADD_POINTS;
    }

    public int returnScore() {
        return this.points;
    }
}

