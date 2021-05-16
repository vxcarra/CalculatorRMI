package InterfacesImplementation;

import Interfaces.Shapes;
import Objects.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ShapesImplementation extends UnicastRemoteObject implements Shapes {

    public ShapesImplementation() throws RemoteException {
        super();
    }

    @Override
    public Triangle getTriangle(double base, double side1, double side2, double height) throws RemoteException {
        return new Triangle(base, side1, side2, height);
    }

    @Override
    public Circle getCircle(double radius) throws RemoteException {
        return new Circle(radius);
    }

    @Override
    public Rectangle getRectangle(double side1, double side2) throws RemoteException {
        return new Rectangle(side1, side2);
    }

    @Override
    public Square getSquare(double side) throws RemoteException {
        return new Square(side);
    }

}
