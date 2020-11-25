package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab04.MapVisualiser;
import pl.edu.agh.po.lab07.IPositionChangeObserver;
import pl.edu.agh.po.lab07.MapBoundary;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected final Map<Vector2d, IMapElement> movableElementsHashMap = new HashMap<>();
    protected final List<Animal> animals = new LinkedList<>();
    protected MapBoundary mapBoundary = new MapBoundary();
    private final MapVisualiser mapVisualiser = new MapVisualiser(this);

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }

    @Override
    abstract public Optional<IMapElement> objectAt(Vector2d position);

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(objectAt(position).isEmpty())
            return true;
        else
            return !objectAt(position).get().isBlocking();
    }

    @Override
    public void place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            movableElementsHashMap.put(animal.getPosition(), animal);
            animal.addObserver(this);
            mapBoundary.addMapElement(animal);
        }
        else
            throw new IllegalArgumentException("Field blocked on " + animal.getPosition());
    }

    @Override
    public void run(List<MoveDirection> directions) {
        int animalsSize = animals.size();
        for (int i = 0; i < directions.size(); i++){
            int index = i % animalsSize;
            Animal previousAnimal = new Animal(this, animals.get(index).getPosition());
            previousAnimal.setOrientation(animals.get(index).getOrientation());
            animals.get(index).move(directions.get(i), this);
            if(!previousAnimal.getPosition().equals(animals.get(index).getPosition())){
                movableElementsHashMap.remove(previousAnimal.getPosition());
                movableElementsHashMap.put(animals.get(index).getPosition(), animals.get(index));
            }
        }
    }

    @Override
    public void positionChanged(IMapElement movedElement, Vector2d oldPosition, Vector2d newPosition) {
        movableElementsHashMap.remove(oldPosition);
        movableElementsHashMap.put(newPosition, movedElement);
        mapBoundary.positionChanged(movedElement, oldPosition, newPosition);
    }

    @Override
    public String toString() {
        return mapVisualiser.draw(mapBoundary.getBoundaries()[0], mapBoundary.getBoundaries()[1]);
    }

}