package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Operations extends Remote {

    //Triangle
    public double areaTriangle(double base, double side1, double side2, double height) throws RemoteException;
    public double perimeterTriangle(double base, double side1, double side2) throws RemoteException;

    //Circle
    public double areaCircle(double radius) throws RemoteException;
    public double circumferenceCircle(double radius) throws RemoteException;

    //Rectangle
    public double areaRectangle(double side1, double side2) throws RemoteException;
    public double perimeterRectangle(double side1, double side2) throws RemoteException;

    //Square
    public double areaSquare(double side) throws RemoteException;
    public double perimeterSquare(double side) throws RemoteException;

}
