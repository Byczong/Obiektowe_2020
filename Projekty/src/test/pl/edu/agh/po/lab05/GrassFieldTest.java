package pl.edu.agh.po.lab05;

import org.junit.Test;
import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab03.OptionsParser;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class GrassFieldTest {
    @Test
    public void movingThroughGrassTest(){
        String [] input = new String []{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        List<MoveDirection> directions = Arrays.asList(new OptionsParser().parse(input));
        GrassField map = new GrassField(10);
        Animal anaconda = new Animal(map);
        Animal grizzly = new Animal(map, new Vector2d(3,4));

        map.place(anaconda);
        map.place(grizzly);
        map.run(directions);

        assertEquals( new Vector2d(2, -1), anaconda.getPosition());
        assertEquals( new Vector2d(3, 7), grizzly.getPosition());
        assertEquals( 10, map.getNumberOfGrasses());
        assertThrows(IllegalArgumentException.class, ()-> map.place(new Animal(map, new Vector2d(2, -1))) );
    }
}