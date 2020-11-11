package pl.edu.agh.po.lab03;

import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab04.RectangularMap;


public class AnimalTest {
        IWorldMap map = new RectangularMap(10, 5);
        Animal lynx1 = new Animal(map);
        Animal lynx2 = new Animal(map);
        Animal lynx3 = new Animal(map);
        MoveDirection[] orders1 = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT};
        MoveDirection[] orders2 = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
        MoveDirection[] orders3 = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT,  MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};

        @Test
        public void moveTest1() {
            Vector2d expectedPos1 = new Vector2d(2, 4);
            MapDirection expectedOrient1 = MapDirection.EAST;
            for (MoveDirection moveDirection : orders1)
                lynx1.oldMove(moveDirection);
            assertEquals(expectedPos1, lynx1.getPosition());
            assertEquals(expectedOrient1, lynx1.getOrientation());

        }
        @Test
        public void moveTest2(){
            Vector2d expectedPos2 = new Vector2d(4, 1);
            MapDirection expectedOrient2 = MapDirection.WEST;
            for (MoveDirection moveDirection : orders2)
                lynx2.oldMove(moveDirection);
            assertEquals(expectedPos2, lynx2.getPosition());
            assertEquals(expectedOrient2, lynx2.getOrientation());

        }
        @Test
    public void moveTest3(){
        Vector2d expectedPos3 = new Vector2d(4, 0);
        MapDirection expectedOrient3 = MapDirection.EAST;
        for (MoveDirection moveDirection : orders3)
            lynx3.oldMove(moveDirection);
        assertEquals(expectedPos3, lynx3.getPosition());
        assertEquals(expectedOrient3, lynx3.getOrientation());
    }
}
