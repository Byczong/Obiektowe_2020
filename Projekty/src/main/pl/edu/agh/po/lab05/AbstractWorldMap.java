package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab04.MapVisualiser;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final Map<Vector2d, Animal> animalHashMap = new HashMap<>();
    protected final List<Animal> animals = new LinkedList<>();
    private final MapVisualiser mapVisualiser = new MapVisualiser(this);

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }

    @Override
    abstract public Optional<AbstractMapElement> objectAt(Vector2d position);

    abstract public Vector2d[] getBoundaries();

    abstract public void adjustMap();

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(objectAt(position).isEmpty())
            return true;
        else
            return !objectAt(position).get().isBlocking();
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.add(animal);
            animalHashMap.put(animal.getPosition(), animal);
            return true;
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
            if(!previousAnimal.getPosition().equals(animals.get(index).getPosition()) || !previousAnimal.getOrientation().equals(animals.get(index).getOrientation())){
                animalHashMap.remove(previousAnimal.getPosition());
                animalHashMap.put(animals.get(index).getPosition(), animals.get(index));
            }
        }
        adjustMap();
    }

    @Override
    public String toString() {
        return mapVisualiser.draw(getBoundaries()[0], getBoundaries()[1]);
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}