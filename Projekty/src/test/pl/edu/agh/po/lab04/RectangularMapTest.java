package pl.edu.agh.po.lab04;

import org.junit.Test;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RectangularMapTest {
    @Test
    public void movingTest() {
        MoveDirection[] input = new MoveDirection[]{ MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT };

        List<MoveDirection> inputList = Arrays.asList(input);
        List<MoveDirection> directions = new LinkedList<>(inputList);

        RectangularMap map = new RectangularMap(5, 5);
        Animal timberWolf = new Animal(map, new Vector2d(3, 3));
        Animal greyWolf = new Animal(map, new Vector2d(5, 3));
        map.place(timberWolf);
        map.place(greyWolf);
        map.run(directions);

        assertEquals(new Vector2d(3, 5), timberWolf.getPosition());
        assertEquals(new Vector2d(5, 5), greyWolf.getPosition());

        assertEquals(MapDirection.WEST, timberWolf.getOrientation());
        assertEquals(MapDirection.EAST, greyWolf.getOrientation());
    }

    @Test
    public void conflictTest() {
        MoveDirection[] directions = new MoveDirection[] {
         MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,
                MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD };

        RectangularMap map = new RectangularMap(10, 5);
        Animal kangaroo = new Animal(map, new Vector2d(5, 2));
        Animal platypus = new Animal(map, new Vector2d(7, 2));
        Animal dingo = new Animal(map, new Vector2d(9, 2));
        map.place(kangaroo);
        map.place(platypus);
        map.place(dingo);


        List<MoveDirection> directionsList = Arrays.asList(directions);
        map.run(directionsList);

        assertEquals(new Vector2d(6, 2), kangaroo.getPosition());
        assertEquals(new Vector2d(7, 2), platypus.getPosition());
        assertEquals(new Vector2d(8, 2), dingo.getPosition());

        assertEquals(MapDirection.EAST, kangaroo.getOrientation());
        assertEquals(MapDirection.EAST, platypus.getOrientation());
        assertEquals(MapDirection.WEST, dingo.getOrientation());
    }

}