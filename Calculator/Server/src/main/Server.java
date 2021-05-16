package main;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server extends UnicastRemoteObject implements MathFunctions {

    public Server() throws RemoteException {
        super();
    }

    @Override
    public double add (double n1, double n2) throws RemoteException {
        return n1 + n2;
    }
    @Override
    public double subtract (double n1, double n2) throws RemoteException {
        return n1 - n2;
    }

    @Override
    public String divide (double n1, double n2) throws RemoteException {
        if (n2 == 0) {
            return  "err";
        } else {
            return String.valueOf(n1 / n2);
        }
    }

    @Override
    public double multiply (double n1, double n2) throws RemoteException {
        return n1 * n2;
    }

    public static void main(String[] args){
        try {
            Registry registry = LocateRegistry.createRegistry(7777);
            registry.rebind("RemoteServer", new Server());
            System.out.println("Server is ready!");
        } catch (RemoteException e){
            System.out.println(e.getMessage());
        }
    }
}