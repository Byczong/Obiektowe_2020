package pl.edu.agh.po.lab02;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapDirectionTest {

    MapDirection dir = MapDirection.NORTH;
    @Test
    public void next() {
        assertEquals(MapDirection.EAST, dir.next());
        assertEquals(MapDirection.SOUTH, dir.next().next());
    }

    @Test
    public void previous() {
        assertEquals(MapDirection.WEST, dir.previous());
        assertEquals(MapDirection.SOUTH, dir.previous().previous());
        assertEquals(MapDirection.EAST, dir.previous().previous().previous());
    }
}