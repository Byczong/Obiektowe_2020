package pl.edu.agh.po.lab03;

import pl.edu.agh.po.lab02.MoveDirection;

import java.util.ArrayList;

public class OptionsParser {

    public static MoveDirection translate(String s) {
        return switch (s) {
            case "forward", "f" -> MoveDirection.FORWARD;
            case "backward", "b" -> MoveDirection.BACKWARD;
            case "right", "r" -> MoveDirection.RIGHT;
            case "left", "l" -> MoveDirection.LEFT;
            default -> throw new IllegalArgumentException(s + " is not legal move specification");
        };
    }

    public MoveDirection[] parse(String[] args) {
        ArrayList<MoveDirection> orders = new ArrayList<>();
        for(String s : args) {
            try {
                orders.add(translate(s));
            }
            catch (IllegalStateException e) {}
        }
        MoveDirection[] arrayOrders = new MoveDirection[orders.size()];
        return orders.toArray( arrayOrders );
    }
}
