package pl.edu.agh.po.lab03;


import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab05.AbstractMapElement;


public class Animal extends AbstractMapElement {
    private MapDirection orientation;
    private Vector2d position;
    private final IWorldMap animalMap;

    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.animalMap = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public boolean isBlocking() {
        return true;
    }

    public void move(MoveDirection direction, IWorldMap map){

        Animal possibleNextAnimal = new Animal(map, this.position);
        possibleNextAnimal.orientation = this.orientation;

        switch (direction) {
            case LEFT -> possibleNextAnimal.orientation = this.orientation.previous();
            case RIGHT -> possibleNextAnimal.orientation = this.orientation.next();
            case FORWARD -> possibleNextAnimal.position = this.position.add(this.orientation.toUnitVector());
            case BACKWARD -> possibleNextAnimal.position = this.position.subtract(this.orientation.toUnitVector());
        }
        if(map.canMoveTo(possibleNextAnimal.position) || this.position == possibleNextAnimal.position){
            this.position = possibleNextAnimal.position;
            this.orientation = possibleNextAnimal.orientation;
        }
    }

    public void oldMove(MoveDirection direction){
        switch (direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> {
                if(World3.wontFallOffMap(this.position, MoveDirection.FORWARD, this.orientation))
                    this.position = this.position.add(this.orientation.toUnitVector());
            }
            case BACKWARD ->{
                if(World3.wontFallOffMap(this.position, MoveDirection.BACKWARD, this.orientation))
                    this.position = this.position.subtract(this.orientation.toUnitVector());
            }
        }
    }

    @Override
    public String toString() {
        String orientationIndicator;
        switch (this.orientation) {
            case NORTH -> orientationIndicator = "^";
            case SOUTH -> orientationIndicator = "v";
            case WEST ->  orientationIndicator = "<";
            case EAST ->  orientationIndicator = ">";
            default -> throw new IllegalStateException("Unexpected value: " + this);
        }
        return orientationIndicator;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public void setOrientation(MapDirection orientation) {
        this.orientation = orientation;
    }
}