package pl.edu.agh.po.lab04;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class RectangularMap implements IWorldMap {

    private final int width, height;
    public List<Animal> animals = new LinkedList<>();
    private final static Vector2d BOTTOMLEFT = new Vector2d(0,0);
    private final Vector2d TOPRIGHT;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        TOPRIGHT = new Vector2d(this.width, this.height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(BOTTOMLEFT) && position.precedes(TOPRIGHT);
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied(animal.getLocation()))
            return false;
        else {
            this.animals.add(animal);
            return true;
        }
    }

    @Override
    public void run(List<MoveDirection> directions) {
        int animalsSize = animals.size();
        for (int i = 0; i < directions.size(); i++)
            animals.get(i % animalsSize).move(directions.get(i), this);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal element: animals)
           if(element.getLocation().equals(position))
               return true;
        return false;
    }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        return Optional.empty();
    }

    @Override
    public String toString() {
        MapVisualiser visualMap = new MapVisualiser(this);
        return visualMap.draw(BOTTOMLEFT, TOPRIGHT);
    }
}
