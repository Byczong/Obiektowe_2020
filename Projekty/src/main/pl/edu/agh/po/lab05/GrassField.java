package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;

import java.util.*;

public class GrassField extends AbstractWorldMap {

    private int numberOfGrasses;
    private final List<Grass> grasses = new LinkedList<>();
    private final Map<Vector2d, Grass> grassHashMap = new HashMap<>();

    public GrassField(int number){
        numberOfGrasses = 0;
        this.placeGrass(numberOfGrasses + number);
    }

    public void placeGrass(int desiredNumberOfGrasses) {
        Random grassGenerator = new Random();
        int grassLimit;

        for(int currentGrass = 0; currentGrass < desiredNumberOfGrasses; currentGrass++) {
            grassLimit = (int)Math.sqrt(numberOfGrasses * 10) + 1;
            Vector2d currentPosition = new Vector2d(grassGenerator.nextInt(grassLimit), grassGenerator.nextInt(grassLimit));
            if (!isOccupied(currentPosition)) {
                Grass grassToAdd = new Grass(currentPosition);
                grasses.add(grassToAdd);
                grassHashMap.put(currentPosition, grassToAdd);
                numberOfGrasses++;
                mapBoundary.addMapElement(grassToAdd);
            }
            else
                currentGrass--;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }

    @Override
    public Optional<IMapElement> objectAt(Vector2d position) {
        
        if(movableElementsHashMap.containsKey(position))
            return Optional.of(movableElementsHashMap.get(position));

        if(grassHashMap.containsKey(position))
            return Optional.of(grassHashMap.get(position));

        return Optional.empty();
    }

    public int getNumberOfGrasses(){
        return numberOfGrasses;
    }

}
