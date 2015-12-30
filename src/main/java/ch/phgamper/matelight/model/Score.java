package ch.phgamper.matelight.model;

public class Score {
    private int points = 0;

    /**
     * Increments the score by a predefined amount
     */
    public void inc() {
        points += Constants.ADD_POINTS;
    }

    /**
     * Resets the screen to zero
     */
    public void reset(){
        points = 0;
    }

    /**
     *
     * @return the score
     */
    public int getPoints() {
        return points;
    }
}

