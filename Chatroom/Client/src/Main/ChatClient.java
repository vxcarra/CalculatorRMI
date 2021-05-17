package Main;

import Interfaces.ClientInterface;
import Interfaces.ServerInterface;

import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatClient extends UnicastRemoteObject implements ClientInterface {

    private static final long serialVersionUID = 7468891722773409712L;
    protected ServerInterface serverInterface;
    protected boolean connectionProblem = false;

    private String host = "localhost";
    private String service = "Chat";
    private String clientService;
    private String name;


    public ChatClient(String name) throws RemoteException {
        this.name = name;
        this.clientService = "ClientListenService_" + name;
    }

    /**
     * Register our own listening service/interface
     * lookup the server RMI interface, then send our details
     * @throws RemoteException
     */
    public void startClient() throws RemoteException {

        String[] details = {name, host, clientService};

        try {

            Registry registry = LocateRegistry.getRegistry(host, 7777);
            registry.rebind(clientService,this);
            serverInterface = (ServerInterface)registry.lookup(service);

        }
        catch (ConnectException e) {

            System.err.println(e.getMessage());
            connectionProblem = true;
            e.printStackTrace();

        } catch(NotBoundException me) {
            connectionProblem = true;
            me.printStackTrace();
        }

        if(!connectionProblem){
            registerWithServer(details);
        }

        System.out.println("Client Listen RMI Server is running...\n");

    }

    /**
     * pass our username, hostname and RMI service name to
     * the server to register out interest in joining the chat
     * @param details
     */
    public void registerWithServer(String[] details) {

        try {

            serverInterface.passIdentity(this.ref);//now redundant ??
            serverInterface.registerListener(details);

        } catch(Exception e){
            e.printStackTrace();
        }

    }


    /**
     * Receive a string from the chat server
     * this is the clients RMI method, which will be used by the server
     * to send messages to us
     */
    @Override
    public void messageFromServer(String message) throws RemoteException {
        System.out.println(message);
    }

}
