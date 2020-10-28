package pl.edu.agh.po.lab03;

import org.junit.Test;
import pl.edu.agh.po.lab02.Vector2d;

import static org.junit.Assert.*;

public class Vector2dTest {

    pl.edu.agh.po.lab02.Vector2d t1 = new pl.edu.agh.po.lab02.Vector2d(1, 2);
    pl.edu.agh.po.lab02.Vector2d t2 = new pl.edu.agh.po.lab02.Vector2d(2, 4);
    pl.edu.agh.po.lab02.Vector2d t3 = new pl.edu.agh.po.lab02.Vector2d(-2, 5);
    pl.edu.agh.po.lab02.Vector2d t4 = new pl.edu.agh.po.lab02.Vector2d(-1, -2);
    @Test
    public void precedes() {
        assertTrue(t1.precedes(t2));
        assertFalse(t2.precedes(t1));
        assertTrue(t4.precedes(t2));
    }

    @Test
    public void follows() {
        assertFalse(t1.follows(t2));
        assertTrue(t2.follows(t1));
        assertFalse(t4.follows(t2));
    }

    @Test
    public void upperRight() {
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(2, 4) ,t1.upperRight(t2));
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(-1, 5) ,t3.upperRight(t4));
    }

    @Test
    public void lowerLeft() {
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(1, 2) ,t1.lowerLeft(t2));
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(-2, -2) ,t3.lowerLeft(t4));
    }

    @Test
    public void add() {
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(3, 6), t1.add(t2));
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(0, 9), t2.add(t3));
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(-3, 3), t3.add(t4));
    }

    @Test
    public void subtract() {
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(-1, -2), t1.subtract(t2));
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(4, -1), t2.subtract(t3));
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(-1, 7), t3.subtract(t4));
    }

    @Test
    public void opposite() {
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(-1, -2), t1.opposite());
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(-2, -4), t2.opposite());
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(2, -5), t3.opposite());
        assertEquals(new pl.edu.agh.po.lab02.Vector2d(1, 2), t4.opposite());
    }

    @Test
    public void testEquals() {
        assertEquals(t1, new pl.edu.agh.po.lab02.Vector2d(1, 2));
        assertEquals(t2, new pl.edu.agh.po.lab02.Vector2d(2, 4));
        assertEquals(t3, new pl.edu.agh.po.lab02.Vector2d(-2, 5));
        assertEquals(t4, new Vector2d(-1, -2));
    }

    @Test
    public void testToString() {
        assertEquals("(1,2)",t1.toString());
        assertEquals("(2,4)",t2.toString());
        assertEquals("(-2,5)",t3.toString());
        assertEquals("(-1,-2)",t4.toString());
    }
}