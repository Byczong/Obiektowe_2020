package pl.edu.agh.po.lab06;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab03.OptionsParser;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab05.GrassField;

import java.util.Arrays;
import java.util.List;

public class World6 {

    public static void main(String[] args) {
        String [] input = new String []{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        IWorldMap map = new GrassField(10);
        Animal anaconda = new Animal(map);
        Animal grizzly = new Animal(map, new Vector2d(2,2));
        try{
            List<MoveDirection> directions = Arrays.asList(new OptionsParser().parse(input));
            map.place(anaconda);
            map.place(grizzly);
            map.run(directions);
        }
        catch (IllegalArgumentException argumentException){
            System.out.println(argumentException + "\nAn illegal argument has been passed over. Ending all processes.");
            System.exit(1);
        }
        System.out.println(map);
        System.out.println(anaconda.getPosition());
        System.out.println(grizzly.getPosition());
    }
}
