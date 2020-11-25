package pl.edu.agh.po.lab07;

import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab05.IMapElement;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private final SortedSet<IMapElement> xSet;
    private final SortedSet<IMapElement> ySet;

    public MapBoundary() {
        xSet = new TreeSet<>( (element1, element2) -> {
            if(element1.getPosition().getX() != element2.getPosition().getX())
                return Integer.compare(element1.getPosition().getX(), element2.getPosition().getX());

            else if(element1.getPosition().getY() != element2.getPosition().getY())
                return Integer.compare(element1.getPosition().getY(), element2.getPosition().getY());
            else
                return Boolean.compare(element1.isBlocking(), element2.isBlocking());
        });

        ySet = new TreeSet<>((element1, element2) -> {
            if(element1.getPosition().getY() != element2.getPosition().getY())
                return Integer.compare(element1.getPosition().getY(), element2.getPosition().getY());
            else if(element1.getPosition().getX() != element2.getPosition().getX())
                return Integer.compare(element1.getPosition().getX(), element2.getPosition().getX());
            else
                return Boolean.compare(element1.isBlocking(), element2.isBlocking());
        });
    }

    public void addMapElement(IMapElement newMapElement) {
        xSet.add(newMapElement);
        ySet.add(newMapElement);
    }

    @Override
    public void positionChanged(IMapElement movedElement, Vector2d oldPosition, Vector2d newPosition) {
        xSet.remove(movedElement);
        ySet.remove(movedElement);
        xSet.add(movedElement);
        ySet.add(movedElement);
    }

    public Vector2d[] getBoundaries(){
        return new Vector2d[]{ new Vector2d( xSet.first().getPosition().getX(), ySet.first().getPosition().getY() ),
                               new Vector2d( xSet.last().getPosition().getX(), ySet.last().getPosition().getY() ) };
    }
}
