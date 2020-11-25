package pl.edu.agh.po.lab07;

import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab05.IMapElement;

/**
 *
 * The interface responsible for publishing
 * potential position changes to observers.
 * @author Byczong
 *
 */

public interface IPositionChangedPublisher {

    void addObserver(IPositionChangeObserver observer);

    void removeObserver(IPositionChangeObserver observer);

    void positionChanged(IMapElement movedElement, Vector2d oldPosition, Vector2d newPosition);
}
