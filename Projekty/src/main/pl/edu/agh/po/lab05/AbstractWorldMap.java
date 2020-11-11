package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab04.MapVisualiser;

import java.util.List;
import java.util.Optional;

public abstract class AbstractWorldMap implements IWorldMap {

    protected MapVisualiser mapVisualiser;
    protected Vector2d bottomLeft;
    protected Vector2d topRight;

    @Override
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }

    @Override
    abstract public boolean place(Animal animal);

    @Override
    abstract public void run(List<MoveDirection> directions);

    @Override
    abstract public Optional<Object> objectAt(Vector2d position);

    @Override
    public String toString() {
        return mapVisualiser.draw(bottomLeft, topRight);
    }
}
