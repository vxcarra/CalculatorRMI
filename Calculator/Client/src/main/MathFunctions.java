package main;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathFunctions extends Remote {

    public double add (double n1, double n2) throws RemoteException;
    public double subtract (double n1, double n2) throws RemoteException;
    public double multiply (double n1, double n2) throws RemoteException;
    public String divide (double n1, double n2) throws RemoteException;

}
