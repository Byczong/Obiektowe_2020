package pl.edu.agh.po.lab03;


import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab04.IWorldMap;


public class Animal {
    private MapDirection orientation;
    private Vector2d location;
    private final IWorldMap animalMap;

    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.animalMap = map;
        this.location = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    public void move(MoveDirection direction, IWorldMap map){

        Animal possibleNextAnimal = new Animal(map, this.location);
        possibleNextAnimal.orientation = this.orientation;

        switch (direction) {
            case LEFT -> possibleNextAnimal.orientation = this.orientation.previous();
            case RIGHT -> possibleNextAnimal.orientation = this.orientation.next();
            case FORWARD -> possibleNextAnimal.location = this.location.add(this.orientation.toUnitVector());
            case BACKWARD -> possibleNextAnimal.location = this.location.subtract(this.orientation.toUnitVector());
        }
        if(map.canMoveTo(possibleNextAnimal.location) || this.location == possibleNextAnimal.location){
            this.location = possibleNextAnimal.location;
            this.orientation = possibleNextAnimal.orientation;
        }
    }

    public void oldMove(MoveDirection direction){
        switch (direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> {
                if(World3.wontFallOffMap(this.location, MoveDirection.FORWARD, this.orientation))
                    this.location = this.location.add(this.orientation.toUnitVector());
            }
            case BACKWARD ->{
                if(World3.wontFallOffMap(this.location, MoveDirection.BACKWARD, this.orientation))
                    this.location = this.location.subtract(this.orientation.toUnitVector());
            }
        }
    }

    @Override
    public String toString() {
        String orientationIndicator = "x";
        switch (this.orientation) {
            case NORTH -> orientationIndicator = "^";
            case SOUTH -> orientationIndicator = "v";
            case WEST ->  orientationIndicator = "<";
            case EAST ->  orientationIndicator = ">";
        }
        return orientationIndicator;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getLocation() {
        return location;
    }
}