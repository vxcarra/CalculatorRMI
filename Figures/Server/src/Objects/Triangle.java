package Objects;

import java.io.Serializable;

public class Triangle implements Serializable {
    private double base;
    private double side1;
    private double side2;
    private double height;

    public Triangle () { }

    public Triangle (double base, double side1, double side2, double height) {
        this.base = base;
        this.side1 = side1;
        this.side2 = side2;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}