package pl.edu.agh.po.lab04;

import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab03.OptionsParser;

import java.util.Arrays;
import java.util.List;

public class World4 {
    public static void main(String[] args) {

        List<MoveDirection> directions = Arrays.asList(new OptionsParser().parse(args));
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        map.place(new Animal(map, new Vector2d(3,4)));
        map.run(directions);
        System.out.println(map);
    }
}
