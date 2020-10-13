package pl.edu.agh.po.lab01;

public class World {
    public static void main(String[] args) {
        System.out.print("Start programu\n");
        Direction[] tab= {Direction.f, Direction.l, Direction.b, Direction.r};
        run(tab);
        System.out.print("\nKoniec dzialania programu");
    }
    public static void run(Direction[] Directiontab) {
        for(Direction Dir : Directiontab){
            switch(Dir){
                case FORWARD:
                    System.out.print("Zwierzak idzie do przodu\n");
                    break;
                case BACKWARDS:
                    System.out.print("Zwierzak idzie do tyłu\n");
                    break;
                case l:
                    System.out.print("Zwierzak idzie w lewo\n");
                    break;
                case r:
                    System.out.print("Zwierzak idzie w prawo\n");
                    break;
            }
        }
    }
}
