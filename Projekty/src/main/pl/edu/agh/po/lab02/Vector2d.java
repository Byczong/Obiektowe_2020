package pl.edu.agh.po.lab02;

import java.util.Objects;

public class Vector2d {

    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other){
        int newx, newy;
        if (this.x >= other.x)
            newx = this.x;
        else
            newx = other.x;

        if (this.y >= other.y)
            newy = this.y;
        else
            newy = other.y;
        return new Vector2d(newx, newy);
    }

    public Vector2d lowerLeft(Vector2d other){
        int newx, newy;
        if (this.x <= other.x)
            newx = this.x;
        else
            newx = other.x;

        if (this.y <= other.y)
            newy = this.y;
        else
            newy = other.y;
        return new Vector2d(newx, newy);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Vector2d v = (Vector2d) other;
        return x == v.x && y == v.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

}
