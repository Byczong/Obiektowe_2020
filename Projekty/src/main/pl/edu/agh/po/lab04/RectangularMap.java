package pl.edu.agh.po.lab04;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab05.AbstractWorldMap;
import pl.edu.agh.po.lab05.IMapElement;


import java.util.List;
import java.util.Optional;

public class RectangularMap extends AbstractWorldMap {

    private static final Vector2d bottomLeft = new Vector2d(0,0);;
    private final Vector2d topRight;

    public RectangularMap(int width, int height){
        topRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(bottomLeft) && position.precedes(topRight);
    }

    @Override
    public void run(List<MoveDirection> directions) {
        int animalsSize = animals.size();
        for (int i=0; i < directions.size(); i++){
            animals.get(i % animalsSize).move(directions.get(i), this);
        }
    }

    @Override
    public Optional<IMapElement> objectAt(Vector2d position) {
        for(Animal animal : animals)
            if(animal.getPosition().equals(position))
                return Optional.of(animal);
        return Optional.empty();
    }
}
