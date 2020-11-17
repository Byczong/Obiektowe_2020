package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;

public class Grass extends AbstractMapElement {
    final private Vector2d position;
    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public boolean isBlocking() {
        return false;
    }

    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "*";
    }
}
