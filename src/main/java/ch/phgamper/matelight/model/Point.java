package ch.phgamper.matelight.model;


public class Point{
    public int X;
    public int Y;

    Point(int x, int y){
        X = x;
        Y = y;
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof Point) && ((Point)o).X == X && ((Point) o).Y == Y;
    }
}

