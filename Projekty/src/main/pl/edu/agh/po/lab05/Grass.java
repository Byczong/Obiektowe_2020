package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;

public class Grass extends AbstractMapElement {

    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public boolean isBlocking() {
        return false;
    }

    @Override
    public String toString() {
        return "*";
    }
}
