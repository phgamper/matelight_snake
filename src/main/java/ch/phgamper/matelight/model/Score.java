package ch.phgamper.matelight.model;

public class Score {
    private int points = 0;

    public void inc() {
        points += Constants.ADD_POINTS;
    }

    public void reset(){
        points = 0;
    }

    public int getPoints() {
        return points;
    }
}

