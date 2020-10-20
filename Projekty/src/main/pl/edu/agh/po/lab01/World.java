package pl.edu.agh.po.lab01;

public class World {
    public static void main(String[] args) {
        System.out.print("Start programu\n\n");
        Direction[] A= {Direction.FORWARD, Direction.LEFT, Direction.BACKWARDS, Direction.RIGHT};
        run(A);
        System.out.print("\nKoniec dzialania programu");
    }
    public static void run(Direction[] directionArray) {
        for(Direction nextDirection : directionArray){
            // "nowy" switch
            switch (nextDirection) {
                case FORWARD -> System.out.print("Zwierzak idzie do przodu\n");
                case BACKWARDS -> System.out.print("Zwierzak idzie do tyłu\n");
                case LEFT -> System.out.print("Zwierzak idzie w lewo\n");
                case RIGHT -> System.out.print("Zwierzak idzie w prawo\n");
            }
        }
    }
}
