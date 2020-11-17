package pl.edu.agh.po.lab03;

import org.junit.Test;

import pl.edu.agh.po.lab02.MoveDirection;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

public class OptionsParserTest {

    @Test
    public void parseTest() {
        String[] orders1 = {"f", "b", "r", "forward", "l"};
        MoveDirection[] desired1 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.LEFT};
        assertArrayEquals(desired1, new OptionsParser().parse(orders1));

    }
    @Test
    public void parseThrowTest(){
        OptionsParser parser = new OptionsParser();
        String[] orders2 = {"left", "backward", "back", "123", "right", "a"};
        assertThrows(IllegalArgumentException.class , () -> parser.parse(orders2));
    }
}