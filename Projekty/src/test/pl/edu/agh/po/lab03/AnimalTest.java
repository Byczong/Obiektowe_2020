package pl.edu.agh.po.lab03;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
        Animal lynx1 = new Animal();
        Animal lynx2 = new Animal();
        Animal lynx3 = new Animal();
        MoveDirection[] orders1 = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT};
        MoveDirection[] orders2 = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
        MoveDirection[] orders3 = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT,  MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};

        @Test
        public void moveTest1() {
            Vector2d expectedPos1 = new Vector2d(2, 4);
            MapDirection expectedOrient1 = MapDirection.EAST;
            for (MoveDirection moveDirection : orders1)
                lynx1.move(moveDirection);
            assertEquals(expectedPos1, lynx1.getLocation());
            assertEquals(expectedOrient1, lynx1.getOrientation());

        }
        @Test
        public void moveTest2(){
            Vector2d expectedPos2 = new Vector2d(4, 1);
            MapDirection expectedOrient2 = MapDirection.WEST;
            for (MoveDirection moveDirection : orders2)
                lynx2.move(moveDirection);
            assertEquals(expectedPos2, lynx2.getLocation());
            assertEquals(expectedOrient2, lynx2.getOrientation());

        }
        @Test
    public void moveTest3(){
        Vector2d expectedPos3 = new Vector2d(4, 0);
        MapDirection expectedOrient3 = MapDirection.EAST;
        for (MoveDirection moveDirection : orders3)
            lynx3.move(moveDirection);
        assertEquals(expectedPos3, lynx3.getLocation());
        assertEquals(expectedOrient3, lynx3.getOrientation());
    }
}
