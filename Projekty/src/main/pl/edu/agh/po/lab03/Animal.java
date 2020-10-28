package pl.edu.agh.po.lab03;

public class Animal {
    private MapDirection orientation;
    private Vector2d location;
    public Animal(){
        orientation = MapDirection.NORTH;
        location = new Vector2d(2, 2);
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case LEFT -> this.orientation = this.orientation.previous();
            case RIGHT -> this.orientation = this.orientation.next();
            case FORWARD -> {
                if(World.wontFallOffMap(this.location, MoveDirection.FORWARD, this.orientation))
                    this.location = this.location.add(this.orientation.toUnitVector());
            }
            case BACKWARD ->{
                if(World.wontFallOffMap(this.location, MoveDirection.BACKWARD, this.orientation))
                    this.location = this.location.subtract(this.orientation.toUnitVector());
            }
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                " orientation= " + orientation +
                ", location= " + location +
                " }";
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getLocation() {
        return location;
    }
}
