package pl.edu.agh.po.lab05;

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
}
