package pl.edu.agh.po.lab02;

public class Vector2d {

    // niemodyfikowalne (final) wspolrzedne x i y
    public final int x;
    public final int y;

    //konstruktor ( przypisuje x i y )
    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }
    public boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d upperRight(Vector2d other){
        int newx, newy;
        if (this.x >= other.x)  newx = this.x;
        else                   newx = other.x;
        if (this.y >= other.y)  newy = this.y;
        else                   newy = other.y;
        return new Vector2d(newx, newy);
    }

    public Vector2d lowerLeft(Vector2d other){
        int newx, newy;
        if (this.x <= other.x)  newx = this.x;
        else                   newx = other.x;
        if (this.y <= other.y)  newy = this.y;
        else                   newy = other.y;
        return new Vector2d(newx, newy);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }


    // metoda equals - sprawdza czy obiekty klasy sa rowne
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Vector2d v = (Vector2d) other;
        return x == v.x && y == v.y;
    }

  // //hashcode - uzywa equals, stosuje sie do haszowania w strukturach
  //public int hashCode() {
  //    return Objects.hash(x, y);
  //}

    // toString
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
