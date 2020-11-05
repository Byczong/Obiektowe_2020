package pl.edu.agh.po.lab04;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab03.OptionsParser;

import java.util.Arrays;
import java.util.List;

public class World4 {
    public static void main(String[] args) {
        String [] input = new String []{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        List<MoveDirection> directions = Arrays.asList(new OptionsParser().parse(input));
        IWorldMap map = new RectangularMap(10, 5);
        Animal anaconda = new Animal(map);
        map.place(anaconda);
        Animal grizzly = new Animal(map, new Vector2d(3,4));
        map.place(grizzly);
        map.run(directions);
        System.out.println(map);
    }
}
