package pl.edu.agh.po.lab04;

import org.junit.Test;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.*;

import static org.junit.Assert.*;

public class RectangularMapTest {
    @Test
    public void movingTest() {
        MoveDirection[] input = new MoveDirection[]{ MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
                MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT };

        List<MoveDirection> directions = new LinkedList<>();
        List<MoveDirection> inputList = Arrays.asList(input);
        directions.addAll(inputList);

        RectangularMap map = new RectangularMap(5, 5);
        map.place(new Animal(map, new Vector2d(3, 3)));
        map.place(new Animal(map, new Vector2d(5, 3)));
        map.run(directions);

        assertEquals(new Vector2d(3, 5), map.animals.get(0).getLocation());
        assertEquals(new Vector2d(5, 5), map.animals.get(1).getLocation());

        assertEquals(MapDirection.WEST, map.animals.get(0).getOrientation());
        assertEquals(MapDirection.EAST, map.animals.get(1).getOrientation());
    }

    @Test
    public void conflictTest() {
        MoveDirection[] directions = new MoveDirection[] {
         MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD,
                MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD };

        RectangularMap map = new RectangularMap(10, 5);
        map.place(new Animal(map, new Vector2d(5, 2)));
        map.place(new Animal(map, new Vector2d(7, 2)));
        map.place(new Animal(map, new Vector2d(9, 2)));


        List<MoveDirection> directionsList = Arrays.asList(directions);
        map.run(directionsList);

        assertEquals(new Vector2d(7, 2), map.animals.get(0).getLocation());
        assertEquals(new Vector2d(7, 2), map.animals.get(1).getLocation());
        assertEquals(new Vector2d(7, 2), map.animals.get(2).getLocation());

        assertEquals(MapDirection.EAST, map.animals.get(0).getOrientation());
        assertEquals(MapDirection.EAST, map.animals.get(1).getOrientation());
        assertEquals(MapDirection.WEST, map.animals.get(2).getOrientation());
    }

}