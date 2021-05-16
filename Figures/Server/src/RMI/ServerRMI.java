package RMI;

import InterfacesImplementation.OperationsImplementation;
import InterfacesImplementation.ShapesImplementation;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {

    public static void main(String[] args) {

        try {

            ShapesImplementation shapesImplementation = new ShapesImplementation();
            OperationsImplementation operationsImplementation = new OperationsImplementation();

            Registry registry = LocateRegistry.createRegistry(7777);
            registry.rebind("RMIShapes", shapesImplementation);
            registry.rebind("RMIOperations", operationsImplementation);

            System.out.println("Server is ready!");

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

}
