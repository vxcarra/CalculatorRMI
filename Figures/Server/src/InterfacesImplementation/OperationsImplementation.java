package InterfacesImplementation;

import Interfaces.Operations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OperationsImplementation extends UnicastRemoteObject implements Operations {

    public OperationsImplementation() throws RemoteException {
        super();
    }

    @Override
    public double areaTriangle(double base, double side1, double side2, double height) throws RemoteException {
        return (base *  height) / 2;
    }

    @Override
    public double perimeterTriangle(double base, double side1, double side2) throws RemoteException {
        return base + side1 + side2;
    }

    @Override
    public double areaCircle(double radius) throws RemoteException {
        return Math.PI * radius * radius;
    }

    @Override
    public double circumferenceCircle(double radius) throws RemoteException {
        return 2 * Math.PI * radius;
    }

    @Override
    public double areaRectangle(double side1, double side2) throws RemoteException {
        return side1 * side2;
    }

    @Override
    public double perimeterRectangle(double side1, double side2) throws RemoteException {
        return 2 * (side1 + side2);
    }

    @Override
    public double areaSquare(double side) throws RemoteException {
        return side * side;
    }

    @Override
    public double perimeterSquare(double side) throws RemoteException {
        return 4 * side;
    }

}
