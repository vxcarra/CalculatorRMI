package Objects;

import java.io.Serializable;

public class Circle implements Serializable {
    private double radius;

    public Circle () { }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}