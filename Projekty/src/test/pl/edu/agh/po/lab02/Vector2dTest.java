package pl.edu.agh.po.lab02;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2dTest {

    Vector2d t1 = new Vector2d(1, 2);
    Vector2d t2 = new Vector2d(2, 4);
    Vector2d t3 = new Vector2d(-2, 5);
    Vector2d t4 = new Vector2d(-1, -2);
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
        assertEquals(new Vector2d(2, 4) ,t1.upperRight(t2));
        assertEquals(new Vector2d(-1, 5) ,t3.upperRight(t4));
    }

    @Test
    public void lowerLeft() {
        assertEquals(new Vector2d(1, 2) ,t1.lowerLeft(t2));
        assertEquals(new Vector2d(-2, -2) ,t3.lowerLeft(t4));
    }

    @Test
    public void add() {
        assertEquals(new Vector2d(3, 6), t1.add(t2));
        assertEquals(new Vector2d(0, 9), t2.add(t3));
        assertEquals(new Vector2d(-3, 3), t3.add(t4));
    }

    @Test
    public void subtract() {
        assertEquals(new Vector2d(-1, -2), t1.subtract(t2));
        assertEquals(new Vector2d(4, -1), t2.subtract(t3));
        assertEquals(new Vector2d(-1, 7), t3.subtract(t4));
    }

    @Test
    public void opposite() {
        assertEquals(new Vector2d(-1, -2), t1.opposite());
        assertEquals(new Vector2d(-2, -4), t2.opposite());
        assertEquals(new Vector2d(2, -5), t3.opposite());
        assertEquals(new Vector2d(1, 2), t4.opposite());
    }

    @Test
    public void testEquals() {
        assertTrue(t1.equals(new Vector2d(1,2)));
        assertTrue(t2.equals(new Vector2d(2,4)));
        assertTrue(t3.equals(new Vector2d(-2,5)));
        assertTrue(t4.equals(new Vector2d(-1,-2)));
    }

    @Test
    public void testToString() {
        assertEquals("(1,2)",t1.toString());
        assertEquals("(2,4)",t2.toString());
        assertEquals("(-2,5)",t3.toString());
        assertEquals("(-1,-2)",t4.toString());
    }
}