package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;

/**
 *
 * The interface responsible for interaction of map elements like Animals or Grasses.
 *
 * @author Byczong
 */

public interface IMapElement {
    /**
     * Indicate if this map element is blocking positions or not.
     *
     * @return True if the object is blocking positions.
     */
    boolean isBlocking();
    /**
     *
     * @return Position of the element.
     *
     */
    Vector2d getPosition();
}
