package pl.edu.agh.po.lab03;

public class World {
    public static boolean wontFallOffMap(Vector2d position, MoveDirection direction, MapDirection orientation)
    {
        Vector2d bottomLeft = new Vector2d(0,0);
        Vector2d topRight   = new Vector2d(4,4);
        if(direction == MoveDirection.FORWARD){
            position = position.add(orientation.toUnitVector());
        }
        else{
            position = position.subtract(orientation.toUnitVector());
        }
        return position.precedes(topRight) && position.follows(bottomLeft);
    }

    public static void main(String[] args) {
        Animal ostrich = new Animal();
        System.out.println(ostrich);

        String[] arr = new String[]{"f", "r", "f", "l", "f", "r", "r", "b", "f", "f", "b", "b", "abc"};
        MoveDirection[] orders = OptionsParser.parse(arr);
        for(MoveDirection order : orders)
        {
            ostrich.move(order);
            System.out.println(ostrich);
        }
    }
}
