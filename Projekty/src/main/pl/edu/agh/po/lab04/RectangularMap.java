package pl.edu.agh.po.lab04;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class RectangularMap implements IWorldMap {

    public final List<Animal> animals = new LinkedList<>();
    private final static Vector2d BOTTOMLEFT = new Vector2d(0,0);
    private final Vector2d TOPRIGHT;
    private final MapVisualiser mapVisualiser;

    public RectangularMap(int width, int height){
        TOPRIGHT = new Vector2d(width, height);
        mapVisualiser = new MapVisualiser(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(BOTTOMLEFT) && position.precedes(TOPRIGHT);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getLocation())) {
            this.animals.add(animal);
            return true;
        }
        else
            return false;
    }

    @Override
    public void run(List<MoveDirection> directions) {
        int animalsSize = animals.size();
        for (int i=0; i < directions.size(); i++){
            System.out.println(this);
            animals.get(i % animalsSize).move(directions.get(i), this);
        }
    }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        for(Animal animal : animals)
            if(animal.getLocation().equals(position))
                return Optional.of(animal);
        return Optional.empty();
    }

    @Override
    public String toString() {
        return mapVisualiser.draw(BOTTOMLEFT, TOPRIGHT);
    }
}
