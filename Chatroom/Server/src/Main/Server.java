package Main;

import Interfaces.ClientInterface;
import Interfaces.ServerInterface;
import Object.Chatter;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Vector;

public class Server extends UnicastRemoteObject implements ServerInterface {

    private static final long serialVersionUID = 1L;
    String line = "---------------------------------------------\n";
    private Vector<Chatter> chatters;


    public Server() throws RemoteException {
        super();
        chatters = new Vector<Chatter>(10, 1);
    }

    public static void main(String[] args) {

        try {

            ServerInterface serverInterface = new Server();
            Registry registry = LocateRegistry.createRegistry(7777);
            registry.rebind("Chat", serverInterface);
            System.out.println("Group Chat RMI Server is ready!");

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateChat(String userName, String chatMessage) throws RemoteException {
        String message = userName + " : " + "\n" + chatMessage;
        sendToAll(message);
    }

    /**
     * Receive a new client remote reference
     */
    @Override
    public void passIdentity(RemoteRef ref) throws RemoteException {

        try {
            System.out.println(line + ref.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Receive a new client and display details to the console
     * send on to register method
     */
    @Override
    public void registerListener(String[] details) throws RemoteException {

        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(details[0] + " has joined the chat session");
        System.out.println(details[0] + "'s hostname : " + details[1]);
        System.out.println(details[0] + "'sRMI service : " + details[2]);
        registerChatter(details);

    }

    @Override
    public void leaveChat(String userName) throws RemoteException {

        for(Chatter c : chatters) {

            if(c.getName().equals(userName)) {

                System.out.println(line + userName + " left the chat session.");
                System.out.println(new Date(System.currentTimeMillis()));
                chatters.remove(c);

                break;
            }

        }

    }

    /**
     * Send a message to all users
     * @param newMessage
     */
    public void sendToAll(String newMessage){

        for(Chatter c : chatters){

            try {
                c.getClient().messageFromServer(newMessage);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * register the clients interface and store it in a reference for
     * future messages to be sent to, ie other members messages of the chat session.
     * send a test message for confirmation / test connection
     * @param details
     */
    private void registerChatter(String[] details) {

        try {

            Registry registry = LocateRegistry.getRegistry(details[1],7777);
            ClientInterface nextClient = (ClientInterface) registry.lookup(details[2]);
            chatters.addElement(new Chatter(details[0], nextClient));
            nextClient.messageFromServer("[Server] : Hello " + details[0] + " you are now free to chat.\n");
            sendToAll("[Server] : " + details[0] + " has joined the group.\n");

        } catch(RemoteException | NotBoundException e){
            e.printStackTrace();
        }

    }

}