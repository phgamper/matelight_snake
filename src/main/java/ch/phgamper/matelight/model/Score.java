package ch.phgamper.matelight.model;

public class Score {
    private int points = 0;

    public void inc() {
        this.points += Constants.ADD_POINTS;
    }

    public int getPoints() {
        return points;
    }
}

