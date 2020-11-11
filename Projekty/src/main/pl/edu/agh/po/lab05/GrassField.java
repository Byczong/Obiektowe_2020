package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab04.MapVisualiser;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


public class GrassField extends AbstractWorldMap {

    private int numberOfGrasses;
    public final List<Animal> animals = new LinkedList<>();
    private final List<Grass> grasses = new LinkedList<>();

    public GrassField(int number){
        numberOfGrasses = 0;
        super.bottomLeft = new Vector2d(0,0);
        super.topRight = new Vector2d(0,0);
        super.mapVisualiser = new MapVisualiser(this);
        this.placeGrass(numberOfGrasses + number);
    }

    public void placeGrass(int desiredNumberOfGrasses) {
        Random grassGenerator = new Random();
        int start = grasses.size();
        int grassLimit;

        for(int currentGrass=0; currentGrass<desiredNumberOfGrasses; currentGrass++) {
            grassLimit = (int)Math.sqrt(numberOfGrasses * 10) + 1;
            Vector2d currentPosition = new Vector2d(grassGenerator.nextInt(grassLimit), grassGenerator.nextInt(grassLimit));
            if (!grassOccupied(currentPosition)) {
                grasses.add(new Grass(currentPosition));
                numberOfGrasses++;
            }
            else
                currentGrass--;
        }
        setBoundaries(animals.size(), start);
    }

    public boolean grassOccupied(Vector2d position) {
        if(objectAt(position).isPresent())
            return isOccupied(position) && objectAt(position).get() instanceof Grass;
        else
            return false;
    }

    public boolean animalOccupied(Vector2d position) {
        if(objectAt(position).isPresent())
            return isOccupied(position) && objectAt(position).get() instanceof Animal;
        else
            return false;
    }

    public void setBoundaries(int start_a, int start_g) {
        int maxX = topRight.getX(), maxY = topRight.getY(), minX = bottomLeft.getX(), minY = bottomLeft.getY();

        for (int i = start_a; i < animals.size(); i++) {
            if (animals.get(i).getPosition().x > maxX) maxX = animals.get(i).getPosition().x;
            if (animals.get(i).getPosition().y > maxY) maxY = animals.get(i).getPosition().y;
            if (animals.get(i).getPosition().x < minX) minX = animals.get(i).getPosition().x;
            if (animals.get(i).getPosition().y < minY) minY = animals.get(i).getPosition().y;
        }

        for (int i = start_g; i < grasses.size(); i++) {
            if (grasses.get(i).getPosition().x > maxX) maxX = grasses.get(i).getPosition().x;
            if (grasses.get(i).getPosition().y > maxY) maxY = grasses.get(i).getPosition().y;
            if (grasses.get(i).getPosition().x < minX) minX = grasses.get(i).getPosition().x;
            if (grasses.get(i).getPosition().y < minY) minY = grasses.get(i).getPosition().y;
        }
        topRight = new Vector2d(maxX, maxY);
        bottomLeft = new Vector2d(minX, minY);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animalOccupied(position);}

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        else
            return false;
    }

    @Override
    public void run(List<MoveDirection> directions) {
        int animalsSize = animals.size();
        for (int i=0; i < directions.size(); i++){
            //System.out.println(this);
            animals.get(i % animalsSize).move(directions.get(i), this);
        }
        setBoundaries(0 ,grasses.size());
    }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        for(Animal animal : animals)
            if(animal.getPosition().equals(position))
                return Optional.of(animal);

        for (Grass grass: grasses)
            if(grass.getPosition().equals(position))
                return Optional.of(grass);

        return Optional.empty();
    }

    public int getNumberOfGrasses(){
        return numberOfGrasses;
    }

}
