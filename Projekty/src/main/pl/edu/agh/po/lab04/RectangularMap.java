package pl.edu.agh.po.lab04;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab05.AbstractWorldMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class RectangularMap extends AbstractWorldMap {

    public final List<Animal> animals = new LinkedList<>();

    public RectangularMap(int width, int height){
        super.bottomLeft = new Vector2d(0,0);
        super.topRight = new Vector2d(width,height);
        super.mapVisualiser = new MapVisualiser(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(bottomLeft) && position.precedes(topRight);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
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
            //System.out.println(this);
            animals.get(i % animalsSize).move(directions.get(i), this);
        }
    }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        for(Animal animal : animals)
            if(animal.getPosition().equals(position))
                return Optional.of(animal);
        return Optional.empty();
    }
}
