package Interfaces;

import Objects.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Shapes extends Remote {

    public Triangle getTriangle(double base, double side1, double side2, double height) throws RemoteException;
    public Circle getCircle(double radius) throws RemoteException;
    public Rectangle getRectangle(double side1, double side2) throws RemoteException;
    public Square getSquare(double side) throws RemoteException;

}
