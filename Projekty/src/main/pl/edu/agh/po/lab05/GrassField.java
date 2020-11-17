package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;

import java.util.*;


public class GrassField extends AbstractWorldMap {

    private int numberOfGrasses;
    private final List<Grass> grasses = new LinkedList<>();
    private final Map<Vector2d, Grass> grassHashMap = new HashMap<>();
    private Vector2d bottomLeft;
    private Vector2d topRight;

    public GrassField(int number){
        numberOfGrasses = 0;
        bottomLeft = new Vector2d(0,0);
        topRight = new Vector2d(0,0);
        this.placeGrass(numberOfGrasses + number);
    }

    public void placeGrass(int desiredNumberOfGrasses) {
        Random grassGenerator = new Random();
        int start = grasses.size();
        int grassLimit;

        for(int currentGrass=0; currentGrass<desiredNumberOfGrasses; currentGrass++) {
            grassLimit = (int)Math.sqrt(numberOfGrasses * 10) + 1;
            Vector2d currentPosition = new Vector2d(grassGenerator.nextInt(grassLimit), grassGenerator.nextInt(grassLimit));
            if (objectAt(currentPosition).isEmpty()) {
                grasses.add(new Grass(currentPosition));
                grassHashMap.put(currentPosition, grasses.get(grasses.size() - 1));
                numberOfGrasses++;
            }
            else
                currentGrass--;
        }
        setBoundaries(animals.size(), start);
    }

    public void adjustMap(){
        setBoundaries(0, grasses.size());
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
    public Vector2d[] getBoundaries(){
        return  new Vector2d[]{bottomLeft, topRight};
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }

    @Override
    public Optional<AbstractMapElement> objectAt(Vector2d position) {

        if(animalHashMap.containsKey(position))
            return Optional.of(animalHashMap.get(position));

        if(grassHashMap.containsKey(position))
            return Optional.of(grassHashMap.get(position));

        return Optional.empty();
    }


    public int getNumberOfGrasses(){
        return numberOfGrasses;
    }

}
