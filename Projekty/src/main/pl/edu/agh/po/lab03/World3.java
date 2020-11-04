package pl.edu.agh.po.lab03;

import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;

public class World3 {

    static final Vector2d BOTTOMLEFT = new Vector2d(0,0);
    static final Vector2d TOPRIGHT   = new Vector2d(4,4);

    public static boolean wontFallOffMap(Vector2d position, MoveDirection direction, MapDirection orientation) {
        if(direction == MoveDirection.FORWARD){
            position = position.add(orientation.toUnitVector());
        }
        else{
            position = position.subtract(orientation.toUnitVector());
        }
        return position.precedes(TOPRIGHT) && position.follows(BOTTOMLEFT);
    }

    public static void main(String[] args) {
        Animal ostrich = new Animal();
        System.out.println(ostrich);

        String[] arr = new String[]{"f", "r", "f", "l", "f", "r", "r", "b", "f", "f", "b", "b", "abc"};
        MoveDirection[] orders = OptionsParser.parse(arr);
        for(MoveDirection order : orders) {
            ostrich.oldMove(order);
            System.out.println(ostrich);
        }
    }
}
