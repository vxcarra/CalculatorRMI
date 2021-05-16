package Objects;

import java.io.Serializable;

public class Square implements Serializable {
    private double side;

    public Square () { }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

}