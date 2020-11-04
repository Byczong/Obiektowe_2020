package pl.edu.agh.po.lab03;

import org.junit.Test;

import pl.edu.agh.po.lab02.MoveDirection;
import static org.junit.Assert.assertArrayEquals;

public class OptionsParserTest {

    @Test
    public void parseTest1() {
        String[] orders1 = {"f", "b", "r", "forward", "l"};
        MoveDirection[] desired1 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT};
        assertArrayEquals(desired1, OptionsParser.parse(orders1));

    }
    @Test
    public void parseTest2(){
        String[] orders2 = {"left", "backward", "back", "123", "right", "a"};
        MoveDirection[] desired2 = {MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.RIGHT};
        assertArrayEquals(desired2, OptionsParser.parse(orders2));
    }
}